package com.sunbeam.ems.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.ems.dtos.Response;
import com.sunbeam.ems.entities.Vendor;
import com.sunbeam.ems.services.VendorServiceImpl;



@CrossOrigin(origins = "*")
@RequestMapping("/Admin")
@RestController
public class AdminController {

	@Autowired
	private VendorServiceImpl vendorService;

	@GetMapping("/allvendors")
	public ResponseEntity<?> getVendors() {
		List<Vendor> list = vendorService.getDetails();
		if (list.isEmpty()) {
			return Response.error("There are no vendors");
		} else {
			return Response.success(list);
		}
	}

	@GetMapping("/newvendors")
	public ResponseEntity<?> getNewVendors() {
		List<Vendor> list = vendorService.getNewDetails();
		if (list.isEmpty()) {
			return Response.error("There are no vendors");
		} else {
			return Response.success(list);
		}
	}

	@PostMapping("/deletevendor/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable int id) {
		vendorService.deleteVendor(id);
		return Response.success(null);
	}

	@PostMapping("/editvendor/{id}")
	public ResponseEntity<?> editVendor(@PathVariable int id) {
		vendorService.editVendor(id);
		return Response.success(null);
	}

	@PostMapping("/details/{id}")
	public ResponseEntity<?> getVendor(@PathVariable int id) {
		Vendor vendor = vendorService.findVendorByID(id);
		return Response.success(vendor);
	}

	

}
