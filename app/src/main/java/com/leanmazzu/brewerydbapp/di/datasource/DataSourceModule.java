package com.leanmazzu.brewerydbapp.di.datasource;

import com.leanmazzu.brewerydbapp.apiservice.retrofit.RetrofitBeerDBApiService;
import com.leanmazzu.brewerydbapp.datasource.RemoteBeersDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {
	
	@Provides
	@Singleton
	RemoteBeersDataSource provideRemoteBeersDataSource(RetrofitBeerDBApiService retrofitBeerDBApiService) {
		return new RemoteBeersDataSource(retrofitBeerDBApiService);
	}
}
