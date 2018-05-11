package com.leanmazzu.brewerydbapp.di.view;

import com.leanmazzu.brewerydbapp.view.beerstyle.BeerStyleFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BeerStyleListFragmentProvider {
	
	@ContributesAndroidInjector(modules = BeerStyleListFragmentModule.class)
	abstract BeerStyleFragment provideBeerStyleFragment();
}
