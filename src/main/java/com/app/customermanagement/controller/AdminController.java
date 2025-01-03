package com.app.customermanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputFilter.Config;
import java.io.OutputStream;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@CrossOrigin("*")
@Component
public class AdminController extends  BaseController{
	
	


    @GetMapping("/export-sql")
    public void exportSqlDump(HttpServletResponse response) throws IOException {
        // Định cấu hình kết nối MySQL
    	ParamConfig paramConfig = new ParamConfig();
        String dbName = CommonConstant.DB_NAME;
        String host = CommonConstant.HOST;
        String osName = System.getProperty("os.name").toLowerCase();
        String urlDump = paramConfig.getUrlDumpWin();
        if(osName.equals("mac")) {
        	urlDump = paramConfig.getUrlDumpMac();
        }
        
        String command = String.format(urlDump, paramConfig.getUser(), paramConfig.getPazzword(), host, dbName);
        
        // Thiết lập response để tải file SQL dump
        response.setContentType("application/sql");
        response.setHeader("Content-Disposition", "attachment; filename=\"database_dump.sql\"");
        System.out.println(command);
        // Chạy câu lệnh và ghi kết quả vào response output stream
//        Process process = Runtime.getRuntime().exec(command);
//        try (InputStream inputStream = process.getInputStream();
//             OutputStream outputStream = response.getOutputStream()) {
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = inputStream.read(buffer)) > 0) {
//                outputStream.write(buffer, 0, length);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
