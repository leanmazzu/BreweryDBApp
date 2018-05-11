package com.leanmazzu.brewerydbapp.core.usecase;

import io.reactivex.disposables.Disposable;

/**
 * The uses cases are the connection between presentation layer and domain layer.
 * A UseCase usually executes the business logic.
 */
public interface UseCase {
	
	Disposable execute();
	void cancel();
}
