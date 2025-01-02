package com.app.customermanagement.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@CrossOrigin("*")
public class AdminController extends  BaseController{

    @GetMapping("/export-sql")
    public void exportSqlDump(HttpServletResponse response) throws IOException {
        // Định cấu hình kết nối MySQL
        String user = "root";
        String password = "12345678";
        String dbName = "dbtest";
        String host = "localhost";

        // Câu lệnh mysqldump macos
        String command = String.format(
                "/usr/local/mysql-8.0.31-macos12-arm64/bin/mysqldump -u%s -p%s -h%s %s", user, password, host, dbName);

        // Thiết lập response để tải file SQL dump
        response.setContentType("application/sql");
        response.setHeader("Content-Disposition", "attachment; filename=\"database_dump.sql\"");

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
            e.printStackTrace();
        }
    }
}
