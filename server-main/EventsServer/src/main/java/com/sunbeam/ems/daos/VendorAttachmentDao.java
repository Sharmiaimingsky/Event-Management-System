package com.sunbeam.ems.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.ems.entities.VendorAttachment;

public interface VendorAttachmentDao extends JpaRepository<VendorAttachment, Integer> {

	VendorAttachment findById(int id);
//	List<VendorAttachment> findByvendorId(int vendorid);
}
