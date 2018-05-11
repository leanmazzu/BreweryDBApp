package com.leanmazzu.brewerydbapp.di;

import com.leanmazzu.brewerydbapp.di.view.BeerStyleListFragmentProvider;
import com.leanmazzu.brewerydbapp.view.beerstyle.BeerStyleListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class ActivityBuilder {
	
	@ContributesAndroidInjector(modules = {
			BeerStyleListFragmentProvider.class})
	abstract BeerStyleListActivity bindBeerStyleListActivity();
	
}
