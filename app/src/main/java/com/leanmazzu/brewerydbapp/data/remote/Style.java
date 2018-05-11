package com.leanmazzu.brewerydbapp.data.remote;

import java.util.Date;

public class Style {

	private String id;
	private String categoryId;
	private StyleCategory category;
	private String name;
	private String shortName;
	private String description;
	private int ibuMin;
	private int ibuMax;
	private float avbMin;
	private float avbMax;
	private int srmMin;
	private int srmMax;
	private double ogMin;
	private double fgMin;
	private double fgMax;
	private Date createDate;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public StyleCategory getCategory() {
		return category;
	}
	
	public void setCategory(StyleCategory category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getIbuMin() {
		return ibuMin;
	}
	
	public void setIbuMin(int ibuMin) {
		this.ibuMin = ibuMin;
	}
	
	public int getIbuMax() {
		return ibuMax;
	}
	
	public void setIbuMax(int ibuMax) {
		this.ibuMax = ibuMax;
	}
	
	public float getAvbMin() {
		return avbMin;
	}
	
	public void setAvbMin(float avbMin) {
		this.avbMin = avbMin;
	}
	
	public float getAvbMax() {
		return avbMax;
	}
	
	public void setAvbMax(float avbMax) {
		this.avbMax = avbMax;
	}
	
	public int getSrmMin() {
		return srmMin;
	}
	
	public void setSrmMin(int srmMin) {
		this.srmMin = srmMin;
	}
	
	public int getSrmMax() {
		return srmMax;
	}
	
	public void setSrmMax(int srmMax) {
		this.srmMax = srmMax;
	}
	
	public double getOgMin() {
		return ogMin;
	}
	
	public void setOgMin(double ogMin) {
		this.ogMin = ogMin;
	}
	
	public double getFgMin() {
		return fgMin;
	}
	
	public void setFgMin(double fgMin) {
		this.fgMin = fgMin;
	}
	
	public double getFgMax() {
		return fgMax;
	}
	
	public void setFgMax(double fgMax) {
		this.fgMax = fgMax;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
