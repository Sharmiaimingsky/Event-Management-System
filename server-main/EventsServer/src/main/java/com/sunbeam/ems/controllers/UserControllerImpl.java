package com.sunbeam.ems.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.ems.dtos.CredentialsUser;
import com.sunbeam.ems.dtos.EventsDTO;
import com.sunbeam.ems.dtos.RatingsDTO;
import com.sunbeam.ems.dtos.Response;
import com.sunbeam.ems.entities.Events;
import com.sunbeam.ems.entities.User;
import com.sunbeam.ems.entities.UserRatings;
//import com.sunbeam.ems.entities.UserService;
import com.sunbeam.ems.services.UserServiceImpl;


@CrossOrigin(origins = "*")
@RestController
public class UserControllerImpl {
   
//	@Autowired
//	private UserService userServices;
   
	@Autowired
	private UserServiceImpl userService;
	
    @GetMapping("/details/{userid}")
	public ResponseEntity<?> findEventsById(@PathVariable("userid") int id) {
    	System.out.println(id);
		List<Events> result = userService.findEventsById(id);
//		for( EventsDTO res : result) {
//
//			System.out.println(res);
//		}
		return Response.success(result);
	}
    
    @PostMapping("/user/signin")
    public ResponseEntity<?> signin(@RequestBody CredentialsUser cred)
    {
    	User status=userService.signin(cred);
		if(status != null)
			return Response.success(status);
		else
			return Response.error(null);
    }
    
    @PostMapping("user/signup")
    public ResponseEntity<?> signup(@RequestBody User user)
    {
    	User user1=userService.signup(user);
    	if(user1 == null)
    		return Response.error(null);
    	else
    		return Response.success(user1);
    }
    
	
//   @GetMapping("/details/{userid}")
//	public ResponseEntity<?> findEventsById(@PathVariable("userid") int id) {
//		User result = userService.getUserByUserid(id);
//		return Response.success(result);
//	}
	
    
//	@PostMapping("/feedback")
//	public ResponseEntity<?> addRatingsAndFeedBack(@RequestBody RatingsDTO ratingsDto) {
//		System.out.println("Inserting: " + ratingsDto);
//		Map<String, Object> result = userService.addRatingsAndFeedBack(ratingsDto);
//		return Response.success(result);
//	}
    
    @PostMapping("events/feedback")
	public ResponseEntity<?> addRatingsAndFeedBack(@RequestBody RatingsDTO ratingsDto) {
		System.out.println("Inserting: " + ratingsDto);
		UserRatings result = userService.addRatingsAndFeedBack(ratingsDto);
		return Response.success(result);
	}
}
