package com.sunbeam.ems.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="vendor")
public class Vendor {
//	 vendorid INT PRIMARY KEY AUTO_INCREMENT,
//	    ->      name VARCHAR(50),
//	    ->      description VARCHAR(500),
//	    ->      rates INT,
//	    ->      vaccination  VARCHAR(50),
//	    ->      experience VARCHAR(500),
//	    ->      category VARCHAR(500),
//	    ->      city  VARCHAR(100),
//	    ->      worksample VARCHAR(500),
//	    ->      mobile_no varchar(50) UNIQUE KEY,
//	    ->      question VARCHAR(500),
//	    ->      answer VARCHAR(500),
//	    ->      flag int
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendorid")
	private int vendorId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "rates")
	private int rates;
	@Column(name = "vaccination")
	private String vaccination;
	@Column(name = "experience")
	private String experience;
	@Column(name = "category")
	private String category;
	@Column(name = "city")
	private String city;
	@Column(name = "mobile_no", unique = true)
	private String mobileNumber;
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + ", description=" + description + ", rates=" + rates
				+ ", vaccination=" + vaccination + ", experience=" + experience + ", category=" + category + ", city="
				+ city + ", mobileNumber=" + mobileNumber + ", question=" + question + ", answer=" + answer + ", flag="
				+ flag + ", attachList=" + attachList + "]";
	}

	@Column(name = "question")
	private String question;
	@Column(name = "answer")
	private String answer;
	@Column(name = "flag")
	private int flag;
	@OneToMany(mappedBy = "vendor")
	private List<VendorAttachment> attachList;
//	@ManyToOne
//	@JoinColumn(name = "eventid")
//	private Events events;
	
	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Vendor(int vendorId) {
		this.vendorId = vendorId;
	}



	public Vendor(int vendorId, String name, int rates, String category) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.rates = rates;
		this.category = category;
	}


	public Vendor(int vendorId, String name, String description, int rates, String vaccination, String experience,
			String category, String city, String mobileNumber, String question, String answer, int flag) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.description = description;
		this.rates = rates;
		this.vaccination = vaccination;
		this.experience = experience;
		this.category = category;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.question = question;
		this.answer = answer;
		this.flag = flag;
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getRates() {
		return rates;
	}



	public void setRates(int rates) {
		this.rates = rates;
	}



	public String getVaccination() {
		return vaccination;
	}



	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
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



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public int isFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}



	public List<VendorAttachment> getAttachList() {
		return attachList;
	}



	public void setAttachList(List<VendorAttachment> attachList) {
		this.attachList = attachList;
	}



	@Override
	public int hashCode() {
		return Objects.hash(vendorId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vendor))
			return false;
		Vendor other = (Vendor) obj;
		return vendorId == other.vendorId;
	}
}
