package com.sunbeam.ems.dtos;

import org.springframework.web.multipart.MultipartFile;

public class VendorDTO {
     
	int id;
	private MultipartFile dataFile;
	private int vendorid;
	
	public VendorDTO() {
		// TODO Auto-generated constructor stub
	}

	public VendorDTO(int id, MultipartFile dataFile, int vendorid) {
		super();
		this.id = id;
		this.dataFile = dataFile;
		this.vendorid = vendorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MultipartFile getDataFile() {
		return dataFile;
	}

	public void setDataFile(MultipartFile dataFile) {
		this.dataFile = dataFile;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	@Override
	public String toString() {
		return "VendorDTO [id=" + id + ", dataFile=" + dataFile + ", vendorid=" + vendorid + "]";
	}

	
	
}
