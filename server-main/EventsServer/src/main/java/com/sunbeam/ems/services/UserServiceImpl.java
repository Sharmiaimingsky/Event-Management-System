package com.sunbeam.ems.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.ems.daos.EventsDao;
import com.sunbeam.ems.daos.UserDao;
import com.sunbeam.ems.daos.UserRatingsDao;
import com.sunbeam.ems.dtos.CredentialsUser;
import com.sunbeam.ems.dtos.DtoEntityConverter;
import com.sunbeam.ems.dtos.EventsDTO;
import com.sunbeam.ems.dtos.RatingsDTO;
import com.sunbeam.ems.entities.Events;
import com.sunbeam.ems.entities.User;
import com.sunbeam.ems.entities.UserRatings;

@Transactional
@Service
public class UserServiceImpl {
	@Autowired
	private EventsDao eventsDao;
	@Autowired
	private UserRatingsDao userRatingsDao;
	@Autowired
	private DtoEntityConverter converter;
	
	@Autowired
	private UserDao userDao;


	public User signin(CredentialsUser cred) {
		User user=userDao.getUserByEmail(cred.getEmail());
		if(user.getPassword().equals( cred.getPassword()))
			return user;
		else
			return null;
		
	}
	public User signup(User user) {
		user.setRole("user");
		return userDao.save(user);
	}
	
	public List<Events> findEventsById(int userid){
		return	eventsDao.findEventsByUserid(userid);
		 	
	}
	
	public UserRatings addRatingsAndFeedBack(RatingsDTO ratingsdto){
		UserRatings ratings = converter.toRatingsEntity(ratingsdto);
//		ratings = userRatingsDao.dataSaving(ratings.getUserid(),ratings.getRatings(),ratings.getFeedback());
//		return Collections.singletonMap("insertedId", ratings.getRatingid());
		
		return userRatingsDao.save(ratings);
	}
	

}
