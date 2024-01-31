package com.sunbeam.ems.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.ems.entities.*;
import com.sunbeam.ems.dtos.Credentials;
import com.sunbeam.ems.dtos.Response;
import com.sunbeam.ems.dtos.VendorDTO;
import com.sunbeam.ems.dtos.VendorDetailsDTO;
import com.sunbeam.ems.entities.Vendor;
import com.sunbeam.ems.services.VendorServiceImpl;

@RequestMapping("/vendors")
@CrossOrigin(origins = "*")
@RestController
public class VendorController {

	@Autowired
	private VendorServiceImpl vendorSImpl;
	
	@PostMapping("/attachment/{vendorid}")
	public ResponseEntity<?> saveVendor(@PathVariable("vendorid") int vendorid, VendorDTO attach){  //vendor
		
		Map<String, Object> result = vendorSImpl.addVendorattachment(vendorid, attach); ////vendor
		return Response.success(result);
	}
	
//	@PostMapping("/vendors/details/{vendorId}")
//	public ResponseEntity<?> saveVendorDetails(@PathVariable("vendorId") int vendorId, VendorDetailsDTO attachDto){  //vendor
//		
//		Vendor result = vendorSImpl.addVendorDetails(vendorId, attachDto); ////vendor
//		return Response.success(result);
//	}
	
	@GetMapping(value = "/attachment/{vendorid}", produces = "image/png")
	public @ResponseBody byte[] downloadAttachment(@PathVariable("vendorid") int vendorid) {
		// get from file --> Java File IO --> byte[] --> return
		VendorAttachment attachment = vendorSImpl.findVendorAttachmentByID(vendorid);
		if(attachment == null)
			return null;
		return attachment.getPhoto();
		
	}
	
	@GetMapping("/details/{vendorId}")
	public ResponseEntity<?> findVendorDetails(@PathVariable("vendorId") int vendorId){
		
//		Vendor vendor = vendorSImpl.findVendorByID(vendorId);
//		
//		return Response.success(vendor);
		List<Vendor> result = vendorSImpl.findVendorDetailsByVendorId(vendorId);
		return Response.success(result);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> findVendorDetailsByCity(@RequestParam(name = "city", defaultValue = "") String city,			                                        
			                                                              HttpServletResponse resp){
		
		List<Vendor> result = new ArrayList<Vendor>();
				
			if(!city.isEmpty())	
			 result = vendorSImpl.findVendorByCity(city);
			 return Response.success(result);
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> findVendorDetails(){
		
		List<Vendor> list = vendorSImpl.getAllVendors();
		return Response.success(list);
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody Credentials cred) {
		Vendor vendor = vendorSImpl.findUserByMobileAndQuestion(cred);
		if (vendor == null)
			return Response.error("vendor not found");
		return Response.success(vendor);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody Vendor vdto) {
		Vendor result = vendorSImpl.save(vdto);

		return Response.success(result);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> editVendor(@PathVariable int id,@RequestBody Vendor v){
		System.out.println(v);
		vendorSImpl.editDetails(v,id);
		return Response.success(null);
	}
	
	@GetMapping("/get/{vendorid}")
	public ResponseEntity<?> getVendor(@PathVariable int vendorid )
	{
		Vendor v=vendorSImpl.findVendorByID(vendorid);
		return Response.success(v);
	}
	
//	@GetMapping("/vendor/v1/details/{vendorId}")
//	public ResponseEntity<?> findVendorSpecificDetails(@PathVariable("vendorId") int vendorId){
//		
//		List<Vendor> result = vendorSImpl.findVendorSpecificDetailsByVendorId(vendorId);
//		return Response.success(result);
//	}
	
	
}
