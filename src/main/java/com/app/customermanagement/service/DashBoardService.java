package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.response.Account;
import com.app.customermanagement.dto.response.Examination;
import com.app.customermanagement.dto.response.Inventory;
import com.app.customermanagement.dto.response.Money;

public interface DashBoardService {
	
	List<Examination> getExamDashBoard();
	Account getAccountDashBoard();
	List<Inventory> getInventoryDashBoard();
	List<Money> getmoneyDashBoard();
}
