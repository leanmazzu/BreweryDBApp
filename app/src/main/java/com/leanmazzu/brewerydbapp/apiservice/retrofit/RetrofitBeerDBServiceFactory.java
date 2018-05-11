package com.leanmazzu.brewerydbapp.apiservice.retrofit;

public class RetrofitBeerDBServiceFactory extends BaseRetrofitServiceFactory {
	
	@Override
	protected String getBaseUrl() {
		return "https://api.brewerydb.com/v2/";
	}
	
	public RetrofitBeerDBApiService getRetrofitBeerDBApiService() {
		return getRetrofit().create(RetrofitBeerDBApiService.class);
	}
}
