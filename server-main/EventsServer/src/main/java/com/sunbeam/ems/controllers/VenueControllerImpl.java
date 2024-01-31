package com.sunbeam.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.ems.dtos.Response;
import com.sunbeam.ems.dtos.SearchFormDTO;
import com.sunbeam.ems.dtos.VenueDataDTO;
import com.sunbeam.ems.entities.Venue;
import com.sunbeam.ems.services.VenueServiceImpl;


@CrossOrigin(origins = "*")
@RestController
public class VenueControllerImpl {
	@Autowired
	private VenueServiceImpl venueService;

	@PostMapping("/venue")
	public ResponseEntity<?> getsearchFilterData(@RequestBody SearchFormDTO SearchDto) {
		System.out.println("Inserting: " + SearchDto);
		List<VenueDataDTO> result = venueService.getsearchFilterData(SearchDto);
		System.out.println(result);
		if(result == null)
			return Response.error(null);
		return Response.success(result);
	}
	
	@GetMapping("/venue/get/{venueid}")
	public ResponseEntity<?> getDetails(@PathVariable int venueid)
	{
		Venue v=venueService.getById(venueid);
		return Response.success(v);
	}
	
	@GetMapping("/search/venues")
	public ResponseEntity<?> getVenueDetails()
	{
		List<Venue> v=venueService.findAll();
		return Response.success(v);
	}
	
}