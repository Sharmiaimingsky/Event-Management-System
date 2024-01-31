
package com.sunbeam.ems.dtos;
import com.sunbeam.ems.entities.Events;

public class VenueDTO {
	private int id;
	private String venuename; 
	private String email;
	private String mobileno;
	private Events event;
	private int price;
	private int capacity;
	private String description;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVenuename() {
		return venuename;
	}
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VenueDTO() {
		super();
	}
	public VenueDTO(int id, String venuename, String email, String mobileno, Events event, int price, int capacity,
			String description, String image) {
		super();
		this.id = id;
		this.venuename = venuename;
		this.email = email;
		this.mobileno = mobileno;
		this.event = event;
		this.price = price;
		this.capacity = capacity;
		this.description = description;
		this.image = image;
	}
	@Override
	public String toString() {
		return "VenueDTO [id=" + id + ", venuename=" + venuename + ", email=" + email + ", mobileno=" + mobileno
				+ ", event=" + event + ", price=" + price + ", capacity=" + capacity + ", description=" + description
				+ ", image=" + image + "]";
	}
	
	
}
