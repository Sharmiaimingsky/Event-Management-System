package com.sunbeam.ems.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="venue_images")
public class VenueImage {
	
	@Id
	@Column(name="image_id")
	private int imageid;
	@Column(name="venueimg")
	private String image;
	@Column(name="venueid")
	private int venueid;
	@OneToOne(mappedBy = "venueImage")
	private Venue venue;
	
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getVenueid() {
		return venueid;
	}
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}
//	public Venue getVenue() {
//		return venue;
//	}
//	public void setVenue(Venue venue) {
//		this.venue = venue;
//	}
//	public VenueImage(int imageid, String image, int venueid, Venue venue) {
//		super();
//		this.imageid = imageid;
//		this.image = image;
//		this.venueid = venueid;
//		this.venue = venue;
//	}
	public VenueImage() {
		
	}
	public VenueImage(int imageid, String image, int venueid) {
		super();
		this.imageid = imageid;
		this.image = image;
		this.venueid = venueid;
	}
	@Override
	public String toString() {
		return "VenueImage [imageid=" + imageid + ", image=" + image + ", venueid=" + venueid  
				+ "]";
	}
	
	
}

