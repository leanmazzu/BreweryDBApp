package com.leanmazzu.brewerydbapp;

import com.leanmazzu.brewerydbapp.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Extend Application to configure Dagger injector
 */
public class BeersApp extends DaggerApplication {
	
	@Override
	protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
		return DaggerAppComponent.builder().application(this).build();
	}
}
