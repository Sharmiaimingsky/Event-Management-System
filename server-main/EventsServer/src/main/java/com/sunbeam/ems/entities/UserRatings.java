package com.sunbeam.ems.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_ratings")
public class UserRatings {
	/**
	 *  ratingid INT PRIMARY KEY AUTO_INCREMENT,
     userid INT,
     ratings FLOAT,*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingid;
	private int userid;
	private String feedback;
//	@OneToOne(mappedBy = "ratingsAndFeedBack")
//	private User user;
	private float ratings;
	
	public UserRatings(int ratingid, int userid, String feedback) {
		super();
		this.ratingid = ratingid;
		this.userid = userid;
		this.feedback = feedback;
		
	}

	public UserRatings(int userid, float ratings, String feedback) {
		super();
		this.userid = userid;
		this.ratings = ratings;
		this.feedback = feedback;
	}

	public UserRatings(int ratingid, int userid, String feedback, float ratings) {
		super();
		this.ratingid = ratingid;
		this.userid = userid;
		this.feedback = feedback;
		this.ratings = ratings;
	}


	public UserRatings() {
		
	}
	
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public int getRatingid() {
		return ratingid;
	}
	public void setRatingid(int ratingid) {
		this.ratingid = ratingid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}

	@Override
	public String toString() {
		return "UserRatings [ratingid=" + ratingid + ", userid=" + userid + ", feedback=" + feedback 
				+ ", ratings=" + ratings + "]";
	}
	
}