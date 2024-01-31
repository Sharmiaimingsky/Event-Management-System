package com.sunbeam.ems.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public class Venue {
	
  @Id
  private int venueid;
  private String venue_name;
  private String email;
  private String event;
  private int venueCapacity;
  private String mobile_no;
  private String description;
  private int price;
  private String city;
public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}

// private String image;
 @OneToOne
 @JoinColumn(name = "venueid", referencedColumnName = "venueid")
 private VenueImage venueImage;
	 
  
  
  
  
	public VenueImage getVenueImage() {
	return venueImage;
}


public void setVenueImage(VenueImage venueImage) {
	this.venueImage = venueImage;
}


	public String getEvent() {
	return event;
}


public Venue(int venueid, String venue_name, String email, String event, int venueCapacity, String mobile_no,
		String description, int price) {
	super();
	this.venueid = venueid;
	this.venue_name = venue_name;
	this.email = email;
	this.event = event;
	this.venueCapacity = venueCapacity;
	this.mobile_no = mobile_no;
	this.description = description;
	this.price = price;
}



public Venue(int venueid, String venue_name, String email, String event, int venueCapacity, String mobile_no,
		String description, int price, String city, VenueImage venueImage) {
	super();
	this.venueid = venueid;
	this.venue_name = venue_name;
	this.email = email;
	this.event = event;
	this.venueCapacity = venueCapacity;
	this.mobile_no = mobile_no;
	this.description = description;
	this.price = price;
	this.city = city;
	this.venueImage = venueImage;
}


public void setEvent(String event) {
	this.event = event;
}


	public Venue(int venueid, String venue_name, String email, int venueCapacity, String mobile_no, String description,
		int price) {
	super();
	this.venueid = venueid;
	this.venue_name = venue_name;
	this.email = email;
	this.venueCapacity = venueCapacity;
	this.mobile_no = mobile_no;
	this.description = description;
	this.price = price;
}


	public Venue() {
		super();
	}
	public Venue(String venue_name, int venueCapacity,int price) {
		this.venue_name = venue_name;
		this.venueCapacity = venueCapacity;
		this.price = price;
		
	} 
 
//  public VenueImage getVenueImage() {
//	return venueImage;
// } 
//  public void setVenueImage(VenueImage venueImage) {
//	this.venueImage = venueImage;
//  }
// public String getImage() {
//	return image;
// }
// public void setImage(String image) {
//	this.image = image;
// }
 public int getPrice() {
	return price;
 }
 public void setPrice(int price) {
	this.price = price;
 }
 public int getVenueid() {
	return venueid;
 }
 public void setVenueid(int venueid) {
	this.venueid = venueid;
 }
  public String getVenue_name() {
	return venue_name;
 }
 public void setVenue_name(String venue_name) {
	this.venue_name = venue_name;
}
 public String getEmail() {
	return email;
 }
 public void setEmail(String email) {
	this.email = email;
 }
 public int getVenueCapacity() {
	return venueCapacity;
 }
 public void setVenueCapacity(int venueCapacity) {
	this.venueCapacity = venueCapacity;
 }
 public String getMobile_no() {
	return mobile_no;
 }
 public void setMobile_no(String mobile_no) {
	this.mobile_no = mobile_no;
}
 public String getDescription() {
	return description;
}
 public void setDescription(String description) {
	this.description = description;
}


@Override
public String toString() {
	return "Venue [venueid=" + venueid + ", venue_name=" + venue_name + ", email=" + email + ", event=" + event
			+ ", venueCapacity=" + venueCapacity + ", mobile_no=" + mobile_no + ", description=" + description
			+ ", price=" + price + ", city=" + city + ", venueImage=" + venueImage + "]";
}
 
//public Venue(int venueid, String venue_name, String email, int venueCapacity, String mobile_no, String description,
//		int price, VenueImage venueImage) {
//	super();
//	this.venueid = venueid;
//	this.venue_name = venue_name;
//	this.email = email;
//	this.venueCapacity = venueCapacity;
//	this.mobile_no = mobile_no;
//	this.description = description;
//	this.price = price;
//	this.venueImage = venueImage;
//}








 
}