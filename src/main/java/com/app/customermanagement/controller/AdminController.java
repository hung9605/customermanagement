package com.app.customermanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.constants.CommonConstant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@CrossOrigin("*")
@Component
public class AdminController extends  BaseController{
	
	@Value("${spring.datasource.username}")
    private static String user;
	@Value("${spring.datasource.password}")
    private static String pazzword;
	@Value("${urlDumpMac}")
    private static String urlDumpMac;
	@Value("${urlDumpWin}")
    private static String urlDumpWin;


    @GetMapping("/export-sql")
    public void exportSqlDump(HttpServletResponse response) throws IOException {
        // Định cấu hình kết nối MySQL

        String dbName = CommonConstant.DB_NAME;
        String host = CommonConstant.HOST;
        String osName = System.getProperty("os.name").toLowerCase();
        String urlDump = "";
        if(osName.equals("win")) {
        	urlDump = urlDumpWin;
        }else {
        // Câu lệnh mysqldump macos
        	urlDump = urlDumpMac;
        }
        
        String command = String.format(urlDump, user, pazzword, host, dbName);
        
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
