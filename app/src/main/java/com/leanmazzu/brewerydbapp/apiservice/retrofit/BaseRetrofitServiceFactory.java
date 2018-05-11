package com.leanmazzu.brewerydbapp.apiservice.retrofit;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.leanmazzu.brewerydbapp.BuildConfig;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Base class for configuring Retrofit.
 */
public abstract class BaseRetrofitServiceFactory {
	
	private Retrofit retrofit;
	
	protected BaseRetrofitServiceFactory() {
		//Configure Jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(df);
		JacksonConverterFactory jacksonConverterFactory = JacksonConverterFactory.create(mapper);
		
		OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();
		
		addInterceptors(httpClientBuilder);
		
		OkHttpClient client = httpClientBuilder.build();
		
		retrofit = new Retrofit.Builder()
				.client(client)
				.baseUrl(getBaseUrl())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(jacksonConverterFactory)
				.build();
	}
	
	protected abstract String getBaseUrl();
	
	protected Retrofit getRetrofit() {
		return retrofit;
	}
	
	protected void addInterceptors(OkHttpClient.Builder httpClientBuilder) {
		// Add Accept json interceptor
		Interceptor acceptJSONInterceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request().newBuilder().addHeader("Accept", "application/json")
						.build();
				
				return chain.proceed(request);
			}
		};
		httpClientBuilder.addInterceptor(acceptJSONInterceptor);
		
		// Add api key interceptor
		Interceptor apiKeyInterceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request original = chain.request();
				HttpUrl originalHttpUrl = original.url();
				
				HttpUrl url = originalHttpUrl.newBuilder()
						.addQueryParameter("key", BuildConfig.API_KEY)
						.build();
				
				// Request customization: add request headers
				Request.Builder requestBuilder = original.newBuilder()
						.url(url);
				
				Request request = requestBuilder.build();
				return chain.proceed(request);
			}
		};
		httpClientBuilder.addInterceptor(apiKeyInterceptor);
		
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		httpClientBuilder.addInterceptor(httpLoggingInterceptor);
	}
}
