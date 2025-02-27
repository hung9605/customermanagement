package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	
	List<Image> findBySuppliesId(Integer suppliesId);

}
