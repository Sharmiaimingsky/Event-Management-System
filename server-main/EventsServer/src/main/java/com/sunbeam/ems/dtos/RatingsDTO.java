package com.sunbeam.ems.dtos;

public class RatingsDTO {
	
	 private int userid;
	 private float ratings;
	 private String feedback;
	
	 
	
	public RatingsDTO(int userid, float ratings, String feedback) {
		super();
		this.userid = userid;
		this.ratings = ratings;
		this.feedback = feedback;
	}



	public RatingsDTO() {
		super();
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public float getRatings() {
		return ratings;
	}



	public void setRatings(float ratings) {
		this.ratings = ratings;
	}



	public String getFeedback() {
		return feedback;
	}



	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	@Override
	public String toString() {
		return "RatingsDTO [userid=" + userid + ", ratings=" + ratings + ", feedback=" + feedback + "]";
	}
	 
	
	
	}
