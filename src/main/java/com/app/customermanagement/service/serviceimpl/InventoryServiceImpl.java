package com.app.customermanagement.service.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.dto.model.InventoryDTO;
import com.app.customermanagement.dto.model.InventoryReportDTO;
import com.app.customermanagement.dto.response.InventoryChartDto;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.repository.InventoryRepository;
import com.app.customermanagement.service.InventoryService;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService{
	
	public final InventoryRepository inventoryRepository;
	public final EntityManager entityManager;
	public final ParamConfig paramConfig;

	@Override
	public List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies) throws Exception {
		return inventoryRepository.findByMedicalSupplies(medicalSupplies);
	}

	@Override
	public List<InventoryDTO> fetchInventoryWithMedicalSupplies() throws Exception {
		return inventoryRepository.fetchInventoryWithMedicalSupplies();
	}

	/**
	 * @param inventory
	 * @return
	 * @throws Exception
	 */
	@Override
	public Inventory add(Inventory inventory) throws Exception {
		 if(Objects.isNull(inventory.getReceivedDate())) {
			 inventory.setReceivedDate(LocalDateTime.now());
		 }
		 if(paramConfig.getIsKafka() == 1) {
			 System.out.println("Send to kafka ... ");
		 }
		return inventoryRepository.save(inventory);
	}

	@Override
	public void update(Inventory inventory) throws Exception {
		inventoryRepository.update(inventory.getQuantity(),inventory.getStatus(), inventory.getLocation(), inventory.getId());
	}

	@Override
	public List<InventoryReportDTO> getData(String fromDate,String toDate) throws Exception {
		return inventoryRepository.getInventoryReport(fromDate, toDate);
	}


	@Override
	public List<InventoryChartDto> getDataChart(String fromDate, String toDate) {
		    LocalDate start = LocalDate.parse(fromDate);
		    LocalDate end = LocalDate.parse(toDate);
		    LocalDateTime startDateTime = start.atStartOfDay();     
		    LocalDateTime endDateTime = end.atTime(LocalTime.MAX);
		return inventoryRepository.getDataChart(startDateTime, endDateTime);
	}

}