package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.customermanagement.dto.model.InventoryDTO;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies);
	
	@Query("SELECT new com.app.customermanagement.dto.model.InventoryDTO(" +
            "i.id, " +
            "ms.medicineName, " +
            "ms.unitPrice, " +
            "i.quantity, " +
            "i.location, " +
            "i.status, " +
            "ms.supplier, " +
            "i.createdAt, " +
            "i.createdBy, " +
            "i.updatedAt, " +
            "i.updatedBy" +
            ") " +
            "FROM Inventory i " +
            "INNER JOIN i.medicalSupplies ms")
    List<InventoryDTO> fetchInventoryWithMedicalSupplies();

}