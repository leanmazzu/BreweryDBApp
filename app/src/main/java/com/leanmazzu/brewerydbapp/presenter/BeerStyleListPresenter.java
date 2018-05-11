package com.leanmazzu.brewerydbapp.presenter;

import com.leanmazzu.brewerydbapp.contract.BeerStyleListContract;
import com.leanmazzu.brewerydbapp.core.presenter.BasePresenter;
import com.leanmazzu.brewerydbapp.core.repository.GetResourceCallback;
import com.leanmazzu.brewerydbapp.data.remote.Style;
import com.leanmazzu.brewerydbapp.usecase.BeerStyleListUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BeerStyleListPresenter extends BasePresenter implements BeerStyleListContract.Presenter, GetResourceCallback<List<Style>> {
	
	private BeerStyleListUseCase beerStyleListUseCase;
	private BeerStyleListContract.View view;
	
	@Inject
	public BeerStyleListPresenter(CompositeDisposable compositeDisposable,
								  BeerStyleListUseCase beerStyleListUseCase,
								  BeerStyleListContract.View view) {
		super(compositeDisposable);
		this.beerStyleListUseCase = beerStyleListUseCase;
		this.view = view;
	}
	
	@Override
	public void loadStyles() {
		beerStyleListUseCase.setGetResourceCallback(this);
		executeUseCase(beerStyleListUseCase);
	}
	
	@Override
	public void cancel() {
		cancelAll();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
	}
	
	@Override
	public void onStart() {
		view.onLoadingStyles();
	}
	
	@Override
	public void onSuccess(List<Style> response) {
		view.onFinishLoadingStyles(response);
	}
	
	@Override
	public void onError(String message) {
		view.onErrorLoadingStyles(message);
	}
	
	@Override
	public void onConnectionError() {
		view.onConnectionErrorLoadingStyles();
	}
}
