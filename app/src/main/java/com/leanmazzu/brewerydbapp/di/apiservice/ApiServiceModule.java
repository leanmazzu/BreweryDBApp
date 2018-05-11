package com.leanmazzu.brewerydbapp.di.apiservice;

import com.leanmazzu.brewerydbapp.apiservice.retrofit.RetrofitBeerDBApiService;
import com.leanmazzu.brewerydbapp.apiservice.retrofit.RetrofitBeerDBServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiServiceModule {
	
	@Provides
	@Singleton
	RetrofitBeerDBServiceFactory provideRetrofitBeerDBServiceFactory() {
		return new RetrofitBeerDBServiceFactory();
	}
	
	@Provides
	@Singleton
	RetrofitBeerDBApiService provideRetrofitBeerDBApiService(RetrofitBeerDBServiceFactory retrofitBeerDBServiceFactory) {
		return retrofitBeerDBServiceFactory.getRetrofitBeerDBApiService();
	}
	
}
