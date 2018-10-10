package com.dto;

public class Airplane {
	private int airplaneId;
	private int firstClassCap;
	private int economyClassCap;
	private String producer;
	private int businessClassCap;
	
	public Airplane() {
		super();
	}
	
	public Airplane(int airplaneId, int firstClassCap, int economyClassCap, String producer, int businessClassCap) {
		super();
		this.airplaneId = airplaneId;
		this.firstClassCap = firstClassCap;
		this.economyClassCap = economyClassCap;
		this.producer = producer;
		this.businessClassCap = businessClassCap;
	}

	public int getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}

	public int getFirstClassCap() {
		return firstClassCap;
	}

	public void setFirstClassCap(int firstClassCap) {
		this.firstClassCap = firstClassCap;
	}

	public int getEconomyClassCap() {
		return economyClassCap;
	}

	public void setEconomyClassCap(int economyClassCap) {
		this.economyClassCap = economyClassCap;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public int getBusinessClassCap() {
		return businessClassCap;
	}

	public void setBusinessClassCap(int businessClassCap) {
		this.businessClassCap = businessClassCap;
	}
}
