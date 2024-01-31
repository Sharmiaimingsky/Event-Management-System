package com.sunbeam.ems.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.ems.entities.*;
import com.sunbeam.ems.daos.VendorAttachmentDao;
import com.sunbeam.ems.daos.VendorDao;
import com.sunbeam.ems.dtos.Credentials;
import com.sunbeam.ems.dtos.DtoEntityConverter;
import com.sunbeam.ems.dtos.VendorDTO;
import com.sunbeam.ems.dtos.VendorDetailsDTO;
import com.sunbeam.ems.entities.Vendor;

@Transactional
@Service
public class VendorServiceImpl {
	
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private DtoEntityConverter converter;
	@Autowired
	private VendorAttachmentDao attachmentDao;

	public Map<String, Object> addVendorattachment(int vendorid, VendorDTO vendorDto) {
		vendorDto.setVendorid(vendorid);
		VendorAttachment attachment = converter.toVendorAttachmentEntity(vendorDto);
		attachment = attachmentDao.save(attachment);
		return Collections.singletonMap("insertedId", attachment.getId());
	}

//	public Vendor addVendorDetails(int vendorId, VendorDetailsDTO vendorDetailsDto) {
//		Vendor vendorDetails = converter.toVendorDetailsEntity(vendorDetailsDto);
//		return vendorDao.save(vendorDetails);
//		
//	}

	
	public Vendor findVendorByID(int vendorId) {
		return vendorDao.findByVendorId(vendorId);
		
	}
	
	public VendorAttachment findVendorAttachmentByID(int vendorid) {
		return attachmentDao.findById(vendorid);
		
	}
	
	public List<Vendor> findVendorDetailsByVendorId(int vendorId) {
		return vendorDao.findVendorDetailsByVendorId(vendorId);
		
	}
	
	public List<Vendor> findVendorByCity(String city){
		
		return vendorDao.findVendorByCity(city);
	}
	
    public List<Vendor> findVendorByCategory(String category){
		
		return vendorDao.findVendorByCategory(category);
	}
	
	
	public List<Vendor> getAllVendors(){
		return vendorDao.findAll();
	}
	
	public List<Vendor> getDetails() {
		return vendorDao.findByFlag(0);
	}

	public List<Vendor> getNewDetails() {
		return vendorDao.findByFlag(1);
	}

	public void deleteVendor(int vendorId) {
		vendorDao.deleteById(vendorId);

	}

	public void editVendor(int vendorId) {
		Vendor v = vendorDao.getById(vendorId);
		v.setFlag(0);
	}


	public void editDetails(Vendor v, int vendorId) {
		
		Vendor v1 = vendorDao.getById(vendorId);
		if (v.getExperience() != "")
			v1.setExperience(v.getExperience());
		if ( v.getCity() != "")
			v1.setCity(v.getCity());
		if (v.getRates() != 0 )
			v1.setRates(v.getRates());
		vendorDao.save(v1);
	}

	public Vendor findUserByMobileAndQuestion(Credentials cred) {
		Vendor dbUser = vendorDao.findBymobileNumber(cred.getmobileNumber());

		if (dbUser != null && (dbUser.getQuestion().equals(cred.getQuestion()))
				&& (dbUser.getAnswer().equals(cred.getAnswer())))
			return dbUser;

		return null;
	}

	public Vendor save(Vendor vdto) {
		return vendorDao.save(vdto);
	}
	
	
	
	
//	public List<Vendor> findVendorSpecificDetailsByVendorId(int vendorId) {
//		return vendorDao.findVendorSpecificDetailsByVendorId(vendorId);
//		
//	}
	
//	public List<Vendor> findVendorDetailsById(int vendorId){
//		
//		List<Vendor> list = vendorDao.findVendorDetailsById(vendorId);
//		return  list;
//	}
//	
	
}
