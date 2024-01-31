package com.sunbeam.ems.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.ems.entities.UserRatings;

public interface UserRatingsDao extends JpaRepository<UserRatings, Integer> {
//	UserRatings saveAll(UserRatings userRatings);
	
	 @Query(value ="insert into `events_db`.`users_ratings`(`userid`, `ratings`, `feedback`) values(1?,2?,3?);", nativeQuery=true)
	 UserRatings dataSaving(int userid,float ratings,String message);
}
