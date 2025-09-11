package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.response.Account;
import com.app.customermanagement.dto.response.Examination;
import com.app.customermanagement.dto.response.Inventory;
import com.app.customermanagement.dto.response.Money;
import com.app.customermanagement.repository.CustomerRepository;
import com.app.customermanagement.repository.InventoryRepository;
import com.app.customermanagement.repository.MedicalExaminationRepository;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.DashBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {
	
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final CustomerRepository customerRepository;
	private final InventoryRepository inventoryRepository;
	private final MedicalExaminationRepository medicalExaminationRepository;

	@Override
	public List<Examination> getExamDashBoard() {
		 return scheduleMedicalRepository.getDataDashBoardExam();
	}

	@Override
	public Account getAccountDashBoard() {
		// TODO Auto-generated method stub
		return customerRepository.getDataDashBoardAccount();
	}

	@Override
	public List<Inventory> getInventoryDashBoard() {
		// TODO Auto-generated method stub
		return inventoryRepository.getDataDashBoardInventory();
	}

	@Override
	public List<Money> getmoneyDashBoard() {
		// TODO Auto-generated method stub
		return medicalExaminationRepository.getDataDashBoardMoney();
	}


}
