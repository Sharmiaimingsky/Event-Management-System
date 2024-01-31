package com.sunbeam.ems.dtos;

public class VendorDetailsDTO {

	private int vendorId; 
	private String name;
	private String experience;
	private String description;
	private String mobileNumber;
	private String category;
	private String city;
	private int rates;
	
	public VendorDetailsDTO() {
		// TODO Auto-generated constructor stub
	}

	public VendorDetailsDTO(int vendorId, String name, String experience, String description, String mobileNumber,
			String category, String city, int rates) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.experience = experience;
		this.description = description;
		this.mobileNumber = mobileNumber;
		this.category = category;
		this.city = city;
		this.rates = rates;
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRates() {
		return rates;
	}

	public void setRates(int rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "VendorDetailsDTO [vendorId=" + vendorId + ", name=" + name + ", experience=" + experience
				+ ", description=" + description + ", mobileNumber=" + mobileNumber + ", category=" + category
				+ ", city=" + city + ", rates=" + rates + "]";
	}

	
}