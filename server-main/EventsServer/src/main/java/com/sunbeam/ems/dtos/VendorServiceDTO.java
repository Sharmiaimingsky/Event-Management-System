package com.sunbeam.ems.dtos;

public class VendorServiceDTO {
   
	private int eventid;
	private int vendorId; 
	private String name;
	private String category;
	private int rates;
	
	public VendorServiceDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public VendorServiceDTO(int eventid) {
		this.eventid = eventid;
	}


	public VendorServiceDTO(int vendorId, String name, String category, int rates) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.category = category;
		this.rates = rates;
	}

	
	
	
	public int getEventid() {
		return eventid;
	}


	public void setEventid(int eventid) {
		this.eventid = eventid;
	}


	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRates() {
		return rates;
	}

	public void setRates(int rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "VendorServiceDTO [vendorId=" + vendorId + ", name=" + name + ", category=" + category + ", rates="
				+ rates + "]";
	}
	
	
	
}
