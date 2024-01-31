package com.sunbeam.ems.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "events")
public class Events {

////	CREATE TABLE events(
//	eventid INT PRIMARY KEY AUTO_INCREMENT,
//	eventName VARCHAR(50),
//	start_date DATE,
//	end_date DATE,
//	vendorid INT,
//	FOREIGN KEY(vendorid) REFERENCES vendor(vendorid),
//	venueid  INT,
//	FOREIGN KEY(venueid) REFERENCES venue(venueid),
//	userid INT,
//	FOREIGN KEY(userid) REFERENCES user(userid),
//	payment_status VARCHAR(50),
//	amount INT,
//	rating_status VARCHAR(10)
//	);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int eventid;
	@Column(name = "payment_status")
	private String paymentStatus;
	@Column(name = "amount")
	private int amount;
	@Column(name = "rating_status") 
	private String ratingStatus;
	@Column
	private int vendorid;
	@Column
	private int userid;
	@Column
	private int venueid;
	public Events() {
		super();
	}
	
	public Events(int eventid,  String paymentStatus, int amount,
			String ratingStatus, int vendorid, int userid, int venueid) {
		super();
		this.eventid = eventid;
		this.paymentStatus = paymentStatus;
		this.amount = amount;
		this.ratingStatus = ratingStatus;
		this.vendorid = vendorid;
		this.userid = userid;
		this.venueid = venueid;
	}

	public Events(String paymentStatus, int amount, int vendorid, int userid, int venueid) {
		super();
		this.paymentStatus = paymentStatus;
		this.amount = amount;
		this.vendorid = vendorid;
		this.userid = userid;
		this.venueid = venueid;
	}

	public int getEventid() {
		return eventid;
	}
	
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public int getAmount() {
		return amount;
	}
	public String getRatingStatus() {
		return ratingStatus;
	}
	public int getVendorid() {
		return vendorid;
	}
	public int getUserid() {
		return userid;
	}
	public int getVenueid() {
		return venueid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setRatingStatus(String ratingStatus) {
		this.ratingStatus = ratingStatus;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}

	@Override
	public String toString() {
		return "Events [eventid=" + eventid + ", paymentStatus=" + paymentStatus + ", amount=" + amount + ", ratingStatus=" + ratingStatus
				+ ", vendorid=" + vendorid + ", userid=" + userid + ", venueid=" + venueid + "]";
	}

	public Events(int vendorid, int userid, int venueid) {
		super();
		this.vendorid = vendorid;
		this.userid = userid;
		this.venueid = venueid;
	}
	
	
	


}
