package com.leanmazzu.brewerydbapp.core.repository;

public interface GetResourceCallback<T> {
	
	/**
	 * Called when start loading the resource
	 */
	void onStart();
	
	/**
	 * Called when the resource was loaded successfully
	 * @param response the loaded resource
	 */
	void onSuccess(T response);
	
	/**
	 * Called when there was an error loading the resource
	 * @param message error message
	 */
	void onError(String message);
	
	/**
	 * Called when there was an error loading the resource because of
	 * a connection error e.g: the device has no connection to internet or failed to connect to a Data Base
	 */
	void onConnectionError();
}
