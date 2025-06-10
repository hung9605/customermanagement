package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies);

}