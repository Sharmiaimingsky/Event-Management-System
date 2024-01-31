package com.sunbeam.ems.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.ems.dtos.EventsDTO;
import com.sunbeam.ems.dtos.VendorServiceDTO;
import com.sunbeam.ems.entities.Events;

public interface EventsDao extends JpaRepository<Events, Integer> {
//
//	Events findEventsByEventid(int eventid);
//	
//	@Query(value = "join query  ", nativeQuery = true)
//	List<Events> findEventsByUserid(int userid);
	
	Events findEventsByEventid(int eventid);
//	@Query(value = "select events.eventid , venue.venue_name, venue.venueCapacity , events.amount, users_ratings.ratings, users_ratings.feedback\r\n"
//			+ "from events\r\n"
//			+ "inner join users_ratings  on events.userid = users_ratings.userid \r\n"
//			+ "inner join venue on venue.venueid=events.venueid\r\n"
//			+ "where events.userid=1? ;", nativeQuery = true)

	List<Events> findEventsByUserid(int userid);
	
//	@Query(value=" select eventid, payment_status,amount from events where userid=?1" , nativeQuery = true)
//	List<EventsDTO> findEventsByUserid(int userid);
	
//	VendorServiceDTO saveServiceDTO(VendorServiceDTO vendor);

//	Events save(int eventid);

//	Events saveAll(int eventid);

//	VendorServiceDTO saveAll(int vendorId);
	
	
}
