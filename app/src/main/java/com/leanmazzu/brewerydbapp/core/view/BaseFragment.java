package com.leanmazzu.brewerydbapp.core.view;

import java.util.concurrent.atomic.AtomicBoolean;

import dagger.android.support.DaggerFragment;


public abstract class BaseFragment extends DaggerFragment {
	
	private AtomicBoolean isRunningTest;
	
	protected void runOnUiThread(Runnable runnable) {
		getActivity().runOnUiThread(runnable);
	}
	
	public synchronized boolean isRunningTest () {
		if (null == isRunningTest) {
			boolean isTest;
			
			try {
				Class.forName (getTestClassName());
				isTest = true;
			} catch (ClassNotFoundException e) {
				isTest = false;
			}
			
			isRunningTest = new AtomicBoolean (isTest);
		}
		
		return isRunningTest.get ();
	}
	
	protected String getTestClassName() {
		return "";
	}
}
