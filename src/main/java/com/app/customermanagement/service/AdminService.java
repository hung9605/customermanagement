package com.app.customermanagement.service;

import com.app.customermanagement.dto.model.Login;

import jakarta.servlet.http.HttpServletResponse;

public interface AdminService {
	void sqlDump(HttpServletResponse response) throws Exception;
	void authentication(HttpServletResponse response,Login login) throws Exception;

}
