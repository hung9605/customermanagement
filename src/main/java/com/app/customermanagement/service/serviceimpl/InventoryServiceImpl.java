package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.model.InventoryDTO;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.repository.InventoryRepository;
import com.app.customermanagement.service.InventoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
	
	public final InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies) throws Exception {
		return inventoryRepository.findByMedicalSupplies(medicalSupplies);
	}

	@Override
	public List<InventoryDTO> fetchInventoryWithMedicalSupplies() throws Exception {
		// TODO Auto-generated method stub
		return inventoryRepository.fetchInventoryWithMedicalSupplies();
	}

	/**
	 * @param inventory
	 * @return
	 * @throws Exception
	 */
	@Override
	public Inventory add(Inventory inventory) throws Exception {
		return inventoryRepository.save(inventory);
	}

}
