package com.sunbeam.ems.services;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.ems.daos.EventsDao;
import com.sunbeam.ems.daos.VendorDao;
import com.sunbeam.ems.daos.VenueDao;
import com.sunbeam.ems.dtos.DtoEntityConverter;
import com.sunbeam.ems.dtos.EventsEntryDTO;
import com.sunbeam.ems.dtos.EventsVendorsDTO;
import com.sunbeam.ems.dtos.VendorServiceDTO;
import com.sunbeam.ems.entities.Events;
import com.sunbeam.ems.entities.Vendor;
import com.sunbeam.ems.entities.Venue;

@Transactional
@Service
public class EventServiceImpl {

	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private EventsDao eventsDao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	@Autowired
	private VenueDao venueDao;

	public void addVendorService(int eventid, int vendorId) {
		Events events = eventsDao.findEventsByEventid(eventid);
		events.setVendorid(vendorId);
		eventsDao.save(events);
	}
	
	public void addVendorService(EventsVendorsDTO vendorId) {
		Events events = eventsDao.findEventsByEventid(vendorId.getEventsid());
		System.out.println(events);
		events.setVendorid(vendorId.getVendorid());
		eventsDao.save(events);
	}

	public Events addEvent(EventsEntryDTO event) {
		
		Venue v = venueDao.getById(event.getId());
		Vendor ve = vendorDao.getById(event.getSid());
		int sum = v.getPrice() + ve.getRates();
		Events e= new Events("Pending", sum , event.getSid(),event.getUid(),event.getId());
		return eventsDao.save(e);
		
	}
	
	public void setStatus(int eventid) {
		Events e= eventsDao.getById(eventid);
		e.setPaymentStatus("success");
		eventsDao.save(e);
		
	}
	
	
//	public Map<String, Object> addVendorService(int eventid, VendorServiceDTO vsDto) {
//		vsDto.setEventid(eventid);
//		 Vendor vendor = converter.toEventEntity(vsDto);
//		 vendor = vendorDao.save(vendor);
//		return Collections.singletonMap("insertedId", vendor.getVendorId());
//	}
}
