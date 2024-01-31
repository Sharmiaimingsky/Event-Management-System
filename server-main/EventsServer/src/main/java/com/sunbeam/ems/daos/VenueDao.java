package com.sunbeam.ems.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.ems.entities.Venue;

public interface VenueDao  extends JpaRepository<Venue, Integer>   {
	
	@Query(value = "select * from  venue where city=?1 and price<=?2 and venueCapacity<=?3 ", nativeQuery = true)
	List<Venue> findByFilterCriteria(String  venue_name,int price,int venuecapacity);
	
	@Query(value = "select * from  venue where venue_name=?1 or price<=?2 or venueCapacity<=?3 order by price desc", nativeQuery = true)
	 List<Venue> SortByPriceDesc(String  venue_name,int price,int venuecapacity);
	
	@Query(value = "select * from  venue where venue_name=?1 or price<=?2 or venueCapacity<=?3 order by venueCapacity desc ", nativeQuery = true)
	 List<Venue> SortByCapacityDesc(String  venue_name,int price,int venuecapacity);

	List<Venue> findVenueByvenueCapacity(int venueCapacity);

}

//select * from  venue where venue_name='Radison' or price<= 8000 or venueCapacity<= 600 order by price , venueCapacity asc;