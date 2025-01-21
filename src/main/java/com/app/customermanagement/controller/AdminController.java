package com.app.customermanagement.controller;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.dto.model.Login;
import com.app.customermanagement.dto.response.ResponseBean;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    public final ParamConfig paramConfig;
    @GetMapping("/export-sql")
    public void exportSqlDump(HttpServletResponse response) throws IOException {
        // Định cấu hình kết nối MySQL
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

    @PostMapping("/auth")
    public ResponseEntity<?> add(@RequestBody Login login){
        return response(new ResponseBean(null));
    }

}
