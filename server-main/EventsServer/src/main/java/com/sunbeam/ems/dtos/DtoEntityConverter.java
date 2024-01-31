package com.sunbeam.ems.dtos;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;

import com.sunbeam.ems.entities.UserRatings;
import com.sunbeam.ems.entities.Vendor;
import com.sunbeam.ems.entities.VendorAttachment;
import com.sunbeam.ems.entities.Venue;

@Component
public class DtoEntityConverter {

	public VendorAttachment toVendorAttachmentEntity (VendorDTO dto) {
	
		if(dto == null)
			return null;
		
		VendorAttachment entity = new VendorAttachment();
		entity.setId(dto.getId());
//		entity.setVendor(new Vendor(dto.getVendorid()));
		try {
			entity.setPhoto(dto.getDataFile().getBytes());
		} catch (Exception e) {
			throw new MultipartException("Can't convert MultipartFile to bytes : " + dto.getDataFile(), e);
		}
		return entity;
	}
	
	public Vendor toVendorDetailsEntity (VendorDetailsDTO vdto) {
		
		if(vdto == null)
			return null;
		
		Vendor entity = new Vendor();
		entity.setVendorId(vdto.getVendorId());
		entity.setName(vdto.getName());
		entity.setExperience(vdto.getExperience());
		entity.setDescription(vdto.getDescription());
		entity.setCategory(vdto.getCategory());
		entity.setCity(vdto.getCity());
		entity.setMobileNumber(vdto.getMobileNumber());
		entity.setRates(vdto.getRates());
	
		return entity;
	}
	
	
//	public EventsDTO toEventsDTO(Events entity) {
//		EventsDTO dto = new EventsDTO();
//		dto.setEventid(entity.getEventid());
//		dto.setVenuename(entity.getVenue().getVenue_name());
//		dto.setEventname(entity.getEventName());
//		dto.setCapacity(entity.getVenue().getVenueCapacity());
//		dto.setPrice(entity.getVenue().getPrice());
//		dto.setRatings(entity.getUserratings().getRatings());
//		dto.setFeedback(entity.getUserratings().getFeedback());
//		return dto;
//	}

	public UserRatings toRatingsEntity(RatingsDTO dto) {
		UserRatings entity = new UserRatings();
		entity.setUserid(dto.getUserid());
		entity.setRatings(dto.getRatings());
		entity.setFeedback(dto.getFeedback());
		return entity;		
	}
	
	
//	public VendorServiceDTO toServiceDTO(VendorServiceDTO vsDto) {
//		
//		if(vsDto == null)
//			return null;
//		
//		VendorServiceDTO dto = new VendorServiceDTO();
//		dto.setVendorId(vsDto.getVendorId());
//		dto.setName(vsDto.getName());
//		dto.setCategory(vsDto.getCategory());
//		dto.setRates(vsDto.getRates());
//		
//		return dto;
//	}
//	
	
	
   public VendorServiceDTO toServiceDTO(Vendor entity) {
	   if(entity == null)
			return null;
	   
	   VendorServiceDTO dto = new VendorServiceDTO();
	   dto.setVendorId(entity.getVendorId());
	   dto.setName(entity.getName());
	   dto.setCategory(entity.getCategory());
	   dto.setRates(entity.getRates());
	   
	   return dto;
   }
	
   /**
    * toEventsDTO
    * toRatingsEntity
    * toVenueEntity
    * toVenueDTO*/
//   	public EventsDTO toEventsDTO(Events entity) {
//   		EventsDTO dto = new EventsDTO();
//   		dto.setEventid(entity.getEventid());
//   		dto.setVenuename(entity.getVenue().getVenue_name());
//   		dto.setEventname(entity.getEventName());
//   		dto.setCapacity(entity.getVenue().getVenueCapacity());
//   		dto.setDuration("3 Days");
//   		dto.setPrice(entity.getVenue().getPrice());
////   		dto.setRatings(entity.getUserratings().getRatings());
////   		dto.setFeedback(entity.getUserratings().getFeedback());
//   		return dto;
//   	}

   	
   	public Venue toVenueEntity(SearchFormDTO dto) {
   		Venue entity = new Venue();
   		entity.setPrice(dto.getPrice());
   		entity.setVenueCapacity(dto.getVenueCapacity());
   		entity.setCity(dto.getCity());
   		return entity;
   	}
   	public VenueDTO toVenueDTO(Venue entity) {
   		VenueDTO dto = new VenueDTO();
   		dto.setCapacity(entity.getVenueCapacity());
   		dto.setDescription(entity.getDescription());
   		dto.setPrice(entity.getPrice());
   		dto.setVenuename(entity.getVenue_name());
//   		dto.setImage(entity.getVenueImage().getImage());
   		return dto;
   	}
	public VenueDataDTO toVenueDataDTO(Venue entity) {
   		VenueDataDTO dto = new VenueDataDTO();
   		dto.setId(entity.getVenueid());
   		dto.setImage(entity.getVenueImage().getImage());
   		dto.setEvent(entity.getEvent());
   		dto.setCapacity(entity.getVenueCapacity());
   		dto.setDescription(entity.getDescription());
   		dto.setPrice(entity.getPrice());
   		dto.setVenuename(entity.getVenue_name());
//   		dto.setImage(entity.getVenueImage().getImage());
   		return dto;
   	}
   
//   public Vendor toServiceEntity(VendorServiceDTO dto) {
//		
//		if(dto == null)
//			return null;
//		
//		Vendor entity = new Vendor();
//		entity.setVendorId(dto.getVendorId());
//		entity.setName(dto.getName());
//		entity.setCategory(dto.getCategory());
//		entity.setRates(dto.getRates());
//		
//		return entity;
//	}
   
//    public Events toEventEntity(VendorServiceDTO dto) {
//    	
//    	if(dto == null)
//			return null;
//    	
//    	Events entity = new Events();
//    	entity.set    	
//    	return entity;
//    }
//   

//   public Vendor toEventEntity(VendorServiceDTO dto) {
//   	
//   	if(dto == null)
//			return null;
//   	
//   	Vendor entity = new Vendor();
//   	entity.setVendorId(dto.getVendorId());
//   
//   	entity.setEvents();
//	entity.setName(dto.getName());
//	entity.setCategory(dto.getCategory());
//	entity.setRates(dto.getRates());
//   	return entity;
//   }
}
