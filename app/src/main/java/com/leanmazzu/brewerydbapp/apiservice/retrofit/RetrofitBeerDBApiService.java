package com.leanmazzu.brewerydbapp.apiservice.retrofit;

import com.leanmazzu.brewerydbapp.data.remote.StylesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RetrofitBeerDBApiService {
	
	@GET("styles")
	Single<StylesResponse> getStyles();
}
