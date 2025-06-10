package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.repository.InventoryRepository;
import com.app.customermanagement.service.InventoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
	
	public final InventoryRepository inventoryRepositoty;

	@Override
	public List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies) throws Exception {
		return inventoryRepositoty.findByMedicalSupplies(medicalSupplies);
	}

}
