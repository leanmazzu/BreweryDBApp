package com.leanmazzu.brewerydbapp.core.presenter;


import com.leanmazzu.brewerydbapp.core.usecase.UseCase;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter {
	
	private CompositeDisposable compositeDisposable;
	
	public BasePresenter(CompositeDisposable compositeDisposable) {
		this.compositeDisposable = compositeDisposable;
	}
	
	protected void executeUseCase(UseCase useCase) {
		compositeDisposable.add(useCase.execute());
	}
	
	public void cancelAll() {
		compositeDisposable.clear();
	}
	
	public void onDetach() {
		compositeDisposable.dispose();
	}
}
