package com.leanmazzu.brewerydbapp.di;

import android.app.Application;

import com.leanmazzu.brewerydbapp.di.apiservice.ApiServiceModule;
import com.leanmazzu.brewerydbapp.di.datasource.DataSourceModule;
import com.leanmazzu.brewerydbapp.di.repository.RepositoryModule;
import com.leanmazzu.brewerydbapp.di.rx.RxModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ApiServiceModule.class,
		RepositoryModule.class, DataSourceModule.class, RxModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
	
	@Component.Builder
	interface Builder {
		@BindsInstance
		Builder application(Application application);
		AppComponent build();
		
	}
	
}
