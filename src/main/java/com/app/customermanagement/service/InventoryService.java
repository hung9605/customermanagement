package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.InventoryDTO;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;

public interface InventoryService {
	
	List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies) throws Exception;
	
	List<InventoryDTO> fetchInventoryWithMedicalSupplies() throws Exception;

	Inventory add(Inventory inventory) throws Exception;

}
