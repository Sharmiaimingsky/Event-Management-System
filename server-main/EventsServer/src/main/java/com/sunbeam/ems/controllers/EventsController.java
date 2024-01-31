package com.sunbeam.ems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.ems.dtos.EventsEntryDTO;
import com.sunbeam.ems.dtos.EventsVendorsDTO;
import com.sunbeam.ems.dtos.Response;
import com.sunbeam.ems.entities.Events;
import com.sunbeam.ems.services.EventServiceImpl;
import com.sunbeam.ems.services.VendorServiceImpl;

@CrossOrigin(origins = "*")
@RequestMapping("/events")
@RestController
public class EventsController {
    
	@Autowired
	private EventServiceImpl eventsSimpl;
	
	@Autowired
	private VendorServiceImpl vendorSImpl;

	//	
//	@PostMapping("/service/{eventid}")
//	public ResponseEntity<?> saveVendorService(@PathVariable("eventid") int eventid, @RequestBody Object vendorId) {
//		int vid = (int)  vendorId; 
//		eventsSimpl.addVendorService(eventid, vid);
//		return Response.success(null);
//	}
	
	@PostMapping("/service")
	public ResponseEntity<?> saveVendorService( @RequestBody EventsVendorsDTO vendorId) {
		System.out.println(vendorId);
		//int i = (int) vendorId;
		eventsSimpl.addVendorService(vendorId);
		return Response.success(null);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEvent(@RequestBody EventsEntryDTO event)
	{
		Events status=eventsSimpl.addEvent(event);
		if(status != null)
			return Response.success(status);
		else
			return Response.error(null);
	}
	
	@PostMapping("/update/{eventid}")
	public ResponseEntity<?> updateStatus(@PathVariable int eventid)
	{
		eventsSimpl.setStatus(eventid);
		return Response.success(null);
	}
}
