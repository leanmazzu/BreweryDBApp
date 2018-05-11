package com.leanmazzu.brewerydbapp.repository;

import com.leanmazzu.brewerydbapp.data.remote.Style;
import com.leanmazzu.brewerydbapp.data.remote.StylesResponse;
import com.leanmazzu.brewerydbapp.datasource.RemoteBeersDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class BeersRepositoryImpl implements BeersRepository {
	
	private RemoteBeersDataSource remoteBeersDataSource;
	
	@Inject
	public BeersRepositoryImpl(RemoteBeersDataSource remoteBeersDataSource) {
		this.remoteBeersDataSource = remoteBeersDataSource;
	}
	
	@Override
	public Single<List<Style>> getBeerStyles() {
		Single<StylesResponse> responseSingle = remoteBeersDataSource.getBeerStyles();
		return responseSingle.flatMap(stylesResponse -> Single.just(stylesResponse.getData()));
	}
}
