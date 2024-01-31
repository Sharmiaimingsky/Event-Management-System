package com.sunbeam.ems.dtos;
import com.sunbeam.ems.entities.Events;

public class VenueDataDTO{
	private int id;
	private String venue_name; 
	private String event;
	private int price;
	private int venueCapacity;
	private String description;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVenuename() {
		return venue_name;
	}
	public void setVenuename(String venuename) {
		this.venue_name = venuename;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity() {
		return venueCapacity;
	}
	public void setCapacity(int capacity) {
		this.venueCapacity= capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VenueDataDTO(int id, String venue_name, String event, int price, int venueCapacity, String description,
			String image) {
		super();
		this.id = id;
		this.venue_name = venue_name;
		this.event = event;
		this.price = price;
		this.venueCapacity = venueCapacity;
		this.description = description;
		this.image = image;
	}
	public VenueDataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
