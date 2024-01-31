package com.sunbeam.ems.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.ems.entities.User;



public interface UserDao extends JpaRepository<User, Integer>  {
 
	@Query("SELECT u FROM User u WHERE u.name = :name")
	public User getUserByUsername(@Param("name") String name);
	public User getUserByEmail(String email);
	public User getUserByUserid(int userid);
}
