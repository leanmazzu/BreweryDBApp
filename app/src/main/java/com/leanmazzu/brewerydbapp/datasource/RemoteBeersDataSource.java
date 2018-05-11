package com.leanmazzu.brewerydbapp.datasource;

import com.leanmazzu.brewerydbapp.apiservice.retrofit.RetrofitBeerDBApiService;
import com.leanmazzu.brewerydbapp.data.remote.StylesResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteBeersDataSource {
	
	private RetrofitBeerDBApiService apiService;
	
	@Inject
	public RemoteBeersDataSource(RetrofitBeerDBApiService apiService) {
		this.apiService = apiService;
	}
	
	public Single<StylesResponse> getBeerStyles() {
		Single<StylesResponse> observable = apiService.getStyles();
		return  observable;
	}
}
