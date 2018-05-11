package com.leanmazzu.brewerydbapp.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {
	
	
	@Binds
	abstract Context bindContext(Application application);
	
	@Provides
	@Singleton
	static SharedPreferences provideSharedPreferences(Application application) {
		return application.getSharedPreferences("SkyscannerPrefs",Context.MODE_PRIVATE);
	}
}
