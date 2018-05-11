package com.leanmazzu.brewerydbapp.contract;

import com.leanmazzu.brewerydbapp.data.remote.Style;

import java.util.List;

public class BeerStyleListContract {
	
	public interface View {
		void onLoadingStyles();
		void onFinishLoadingStyles(List<Style> beerStyles);
		void onErrorLoadingStyles(String errorMessage);
		void onConnectionErrorLoadingStyles();
	}
	
	public interface Presenter {
		void loadStyles();
		void cancel();
		void onDetach();
	}
}
