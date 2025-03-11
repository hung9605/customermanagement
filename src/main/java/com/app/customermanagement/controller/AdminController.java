package com.app.customermanagement.controller;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.dto.model.Login;
import com.app.customermanagement.dto.model.TimeConfig;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.AdminService;
import com.app.customermanagement.service.TimeService;

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
    private final AdminService adminService;
    private final TimeService timeService;
    
    @GetMapping("/export-sql")
    public void exportSqlDump(HttpServletResponse response,@RequestParam String username,@RequestParam String password	) throws IOException {
        try {
        	Login login = new Login(username, password);
			adminService.authentication(response, login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @PostMapping("/auth")
    public ResponseEntity<?> add(@RequestBody Login login){
        return response(new ResponseBean(null));
    }
    
    @PostMapping("/configtime")
    public ResponseEntity<?> configTimes(@RequestBody TimeConfig timeConfig){
    	try {
			timeService.configTime(timeConfig.getStartTime(), timeConfig.getEndTime(), timeConfig.getIntervalTime());
			return response(new ResponseBean(CommonConstant.OK));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
        
    }
    
    @GetMapping("/gettime")
    public ResponseEntity<?> getTime(){
    	try {
			return response(new ResponseBean(timeService.getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
        
    }
    

}
