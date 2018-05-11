package com.leanmazzu.brewerydbapp.repository;

import com.leanmazzu.brewerydbapp.data.remote.Style;

import java.util.List;

import io.reactivex.Single;

public interface BeersRepository {
	
	Single<List<Style>> getBeerStyles();
}
