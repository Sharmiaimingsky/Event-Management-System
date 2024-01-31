package com.sunbeam.ems.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.ems.daos.VenueDao;
import com.sunbeam.ems.dtos.DtoEntityConverter;
import com.sunbeam.ems.dtos.SearchFormDTO;
import com.sunbeam.ems.dtos.VenueDataDTO;
import com.sunbeam.ems.entities.Venue;

@Transactional
@Service
public class VenueServiceImpl {
	@Autowired
	private VenueDao venueDao;
	@Autowired
	private DtoEntityConverter converter;
	public List<VenueDataDTO> getsearchFilterData(SearchFormDTO SearchDto){
		Venue venue = converter.toVenueEntity(SearchDto);
		List<Venue> listofvenues = venueDao.findByFilterCriteria(venue.getCity(),venue.getPrice(),venue.getVenueCapacity());
		return listofvenues.stream().map(bc -> converter.toVenueDataDTO(bc)).collect(Collectors.toList());	
	}
  
	 public Venue getById(int venueid) {
		
		return venueDao.getById(venueid);
	}

	public List<Venue> findAll() {
		
	 return	venueDao.findAll();
	}
}
