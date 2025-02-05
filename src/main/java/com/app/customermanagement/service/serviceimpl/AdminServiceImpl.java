package com.app.customermanagement.service.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.Login;
import com.app.customermanagement.service.AdminService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{
	
	public final ParamConfig paramConfig;
	
	

	@Override
	public void sqlDump(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 String dbName = CommonConstant.DB_NAME;
	        String host = CommonConstant.HOST;
	        String osName = System.getProperty("os.name").toLowerCase().substring(0, 3);
	        String urlDump = paramConfig.getUrlDumpWin();
	        if(osName.equals("mac")) {
	            urlDump = paramConfig.getUrlDumpMac();
	        }
	        String command = String.format(urlDump, paramConfig.getUser(), paramConfig.getPazzword(), host, dbName);
	        // Thiết lập response để tải file SQL dumpcmd
	        response.setContentType("application/sql");
	        response.setHeader("Content-Disposition", "attachment; filename=\"database_dump.sql\"");
	        System.out.println(command);
	        // Chạy câu lệnh và ghi kết quả vào response output stream
	        Process process = Runtime.getRuntime().exec(command);
	        try (InputStream inputStream = process.getInputStream();
	             OutputStream outputStream = response.getOutputStream()) {
	            byte[] buffer = new byte[1024];
	            int length;
	            while ((length = inputStream.read(buffer)) > 0) {
	                outputStream.write(buffer, 0, length);
	            }
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}

	@Override
	public void authentication(HttpServletResponse response,Login login) throws Exception {
		// TODO Auto-generated method stub
		if(login.getUsername().equals("tnd") && login.getPassword().equals("tnd")) {
			sqlDump(response);
		}else {
			throw new Exception("Authentication fail!");
		}
	}

}
