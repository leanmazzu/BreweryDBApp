package com.leanmazzu.brewerydbapp.apiservice.retrofit;

import com.leanmazzu.brewerydbapp.data.remote.StylesResponse;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;


public class RetrofitBeerDBApiServiceIntegrationTest {
	
	private RetrofitBeerDBApiService service;
	
	@Before
	public void setUp() {
		RetrofitBeerDBServiceFactory retrofitBeerDBServiceFactory = new RetrofitBeerDBServiceFactory();
		service = retrofitBeerDBServiceFactory.getRetrofitBeerDBApiService();
	}
	
	@Test
	public void getStyles() {
		StylesResponse stylesResponse = service.getStyles().blockingGet();
		assertNotNull(stylesResponse);
		assertNotNull(stylesResponse.getData());
	}
}