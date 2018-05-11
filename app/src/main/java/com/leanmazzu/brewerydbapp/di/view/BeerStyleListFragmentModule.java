package com.leanmazzu.brewerydbapp.di.view;

import com.leanmazzu.brewerydbapp.contract.BeerStyleListContract;
import com.leanmazzu.brewerydbapp.presenter.BeerStyleListPresenter;
import com.leanmazzu.brewerydbapp.repository.BeersRepository;
import com.leanmazzu.brewerydbapp.usecase.BeerStyleListUseCase;
import com.leanmazzu.brewerydbapp.view.beerstyle.BeerStyleFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class BeerStyleListFragmentModule {
	
	@Provides
	static BeerStyleListUseCase provideBeerStyleListUseCase(BeersRepository beersRepository) {
		return new BeerStyleListUseCase(beersRepository);
	}
	
	@Provides
	static BeerStyleListContract.Presenter provideBeerStyleListPresenter(CompositeDisposable compositeDisposable,
																  BeerStyleListUseCase beerStyleListUseCase,
																  BeerStyleListContract.View view) {
		return new BeerStyleListPresenter(compositeDisposable, beerStyleListUseCase, view);
	}
	
	@Binds
	abstract BeerStyleListContract.View provideBeerStyleListView(BeerStyleFragment beerStyleFragment);
}
