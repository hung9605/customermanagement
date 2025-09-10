package com.app.customermanagement.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.response.Account;
import com.app.customermanagement.dto.response.Examination;
import com.app.customermanagement.repository.CustomerRepository;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.DashBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashBoardServiceImpl implements DashBoardService {
	
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final CustomerRepository customerRepository;

	@Override
	public Examination getExamDashBoard() {
		 return scheduleMedicalRepository.getDataDashBoardExam();
	}

	@Override
	public Account getAccountDashBoard() {
		// TODO Auto-generated method stub
		return customerRepository.getDataDashBoardAccount();
	}


}
