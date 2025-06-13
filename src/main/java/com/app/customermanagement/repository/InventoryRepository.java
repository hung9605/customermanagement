package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
            "INNER JOIN i.medicalSupplies ms ORDER BY ms.medicineName,i.receivedDate")
    List<InventoryDTO> fetchInventoryWithMedicalSupplies();
	
	@Transactional
	@Modifying
	@Query("update Inventory i set i.quantity = :quantity,i.status = :status,i.location= :location where i.id = :id")
	void update(@Param("quantity") Integer quantity,@Param("status") String status
	,@Param("location") String location, @Param("id") Long id);

}