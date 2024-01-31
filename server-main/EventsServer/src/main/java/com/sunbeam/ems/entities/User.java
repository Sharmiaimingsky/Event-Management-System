package com.sunbeam.ems.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
/*
 *   userid INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE KEY,
    provider VARCHAR(20),
    role VARCHAR(50) DEFAULT 'user'*/
	@Id
	private int userid;
	private String name;
	private String email;
//	@Enumerated(EnumType.STRING)
	private String password;
	private String Role;
	
//	@OneToMany(mappedBy = "user")
//	private List<Events> eventlist;

	@OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
	private UserRatings ratingsAndFeedBack;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(int userid) {
		super();
		this.userid = userid;
	}


	public User(int userid, String name, String email, String password, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		Role = role;
	}


	public User(int userid, String name, String email, String role, 
			UserRatings ratingsAndFeedBack) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		Role = role;
		
		this.ratingsAndFeedBack = ratingsAndFeedBack;
	}


	
	public UserRatings getRatingsAndFeedBack() {
		return ratingsAndFeedBack;
	}
	public void setRatingsAndFeedBack(UserRatings ratingsAndFeedBack) {
		this.ratingsAndFeedBack = ratingsAndFeedBack;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getProvider() {
//		return Provider;
//	}
//	public void setProvider(String provider) {
//		Provider = provider;
//	}
	
	
	public String getRole() {
		return Role;
	}
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


//	public Provider getProvider() {
//		return provider;
//	}
//
//
//	public void setProvider(Provider provider) {
//		this.provider = provider;
//	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRole(String role) {
		Role = role;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", provider=" + password + ", Role="
				+ Role  + ", ratingsAndFeedBack=" + ratingsAndFeedBack + "]";
	}

	
}
