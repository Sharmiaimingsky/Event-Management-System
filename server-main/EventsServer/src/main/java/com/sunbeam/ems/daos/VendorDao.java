package com.sunbeam.ems.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeam.ems.dtos.VendorServiceDTO;
import com.sunbeam.ems.entities.Vendor;

public interface VendorDao extends JpaRepository<Vendor, Integer> {

	Vendor findByVendorId(int vendorId);
	
	List<Vendor> findVendorDetailsByVendorId(int vendorId);
	
	List<Vendor> findVendorByCity(String city);
	
	List<Vendor> findVendorByCategory(String category);
	
	List<Vendor> findByFlag(int i);

	Vendor findBymobileNumber(String mobileNumber);

//	VendorServiceDTO saveAll(VendorServiceDTO vendor);
	
//	@Query(value = "SELECT vendorid, name, experience, mobile_no, description, vaccination, rates FROM vendor WHERE vendorId = ?1" , nativeQuery = true)
//	List<Vendor> findVendorSpecificDetailsByVendorId(int vendorId); //@Param("vendorId") 
}
