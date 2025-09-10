package com.app.customermanagement.service;

import com.app.customermanagement.dto.response.Account;
import com.app.customermanagement.dto.response.Examination;

public interface DashBoardService {
	
	Examination getExamDashBoard();
	Account getAccountDashBoard();

}
