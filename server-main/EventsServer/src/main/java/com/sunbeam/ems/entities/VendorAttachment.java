package com.sunbeam.ems.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sunbeam.ems.entities.Vendor;

@Entity
@Table(name = "vendor_attachment")
public class VendorAttachment {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	@ManyToOne
	@JoinColumn(name = "vendorid")
	private Vendor vendor;
	
	public VendorAttachment() {
		// TODO Auto-generated constructor stub
	}

	public VendorAttachment(int id, byte[] photo) {
		super();
		this.id = id;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "VendorAttachment [id=" + id + ", photo=" + Arrays.toString(photo) + ", vendor=" + vendor + "]";
	}
	
	
}
