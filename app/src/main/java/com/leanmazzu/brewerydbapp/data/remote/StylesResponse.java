package com.leanmazzu.brewerydbapp.data.remote;

import java.util.List;

public class StylesResponse {

	private String message;
	private List<Style> data;
	private String status;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Style> getData() {
		return data;
	}
	
	public void setData(List<Style> data) {
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
