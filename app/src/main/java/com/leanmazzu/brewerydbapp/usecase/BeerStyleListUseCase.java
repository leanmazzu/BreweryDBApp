package com.leanmazzu.brewerydbapp.usecase;

import com.leanmazzu.brewerydbapp.core.repository.GetResourceCallback;
import com.leanmazzu.brewerydbapp.core.usecase.UseCase;
import com.leanmazzu.brewerydbapp.data.remote.Style;
import com.leanmazzu.brewerydbapp.repository.BeersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BeerStyleListUseCase implements UseCase {
	
	private Disposable useCaseDisposable;
	private BeersRepository beersRepository;
	private GetResourceCallback<List<Style>> getResourceCallback;
	
	@Inject
	public BeerStyleListUseCase(BeersRepository beersRepository) {
		this.beersRepository = beersRepository;
	}
	
	@Override
	public Disposable execute() {
		getResourceCallback.onStart();
		useCaseDisposable = beersRepository.getBeerStyles()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						styles -> getResourceCallback.onSuccess(styles),
						throwable -> getResourceCallback.onError(throwable.getMessage()));
		return useCaseDisposable;
	}
	
	@Override
	public void cancel() {
		if (useCaseDisposable != null && !useCaseDisposable.isDisposed()) {
			useCaseDisposable.dispose();
		}
	}
	
	public void setGetResourceCallback(GetResourceCallback<List<Style>> getResourceCallback) {
		this.getResourceCallback = getResourceCallback;
	}
}
