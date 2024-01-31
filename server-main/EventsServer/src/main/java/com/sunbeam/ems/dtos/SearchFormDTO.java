package com.sunbeam.ems.dtos;

import java.util.Date;

public class SearchFormDTO {
	private String city;
	private int price;
	private int venueCapacity;

	public SearchFormDTO() {
		super();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVenueCapacity() {
		return venueCapacity;
	}

	public void setVenueCapacity(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}

	public SearchFormDTO(String city, int price, int venueCapacity) {
		super();
		this.city = city;
		this.price = price;
		this.venueCapacity = venueCapacity;
	}

	@Override
	public String toString() {
		return "SearchFormDTO [city=" + city + ", price=" + price + ", venueCapacity=" + venueCapacity + "]";
	}

}
