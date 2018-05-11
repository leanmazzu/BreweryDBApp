package com.leanmazzu.brewerydbapp.di.repository;

import com.leanmazzu.brewerydbapp.datasource.RemoteBeersDataSource;
import com.leanmazzu.brewerydbapp.repository.BeersRepository;
import com.leanmazzu.brewerydbapp.repository.BeersRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
	
	@Provides
	@Singleton
	BeersRepository provideBeersRepository(RemoteBeersDataSource remoteBeersDataSource) {
		return new BeersRepositoryImpl(remoteBeersDataSource);
	}
}
