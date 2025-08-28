package com.app.customermanagement.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.Login;
import com.app.customermanagement.dto.model.TimeConfig;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.AdminService;
import com.app.customermanagement.service.TimeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@CrossOrigin("*")
public class AdminController extends  BaseController{

    public  final ParamConfig paramConfig;
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

	@GetMapping("/getcodesupabase")
	public ResponseEntity<?> getCodeSupaBase(){
		try {
			return response(new ResponseBean("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZlb2h1aHRmeG9la3R4d2ZnYWVwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU5NjQ1ODcsImV4cCI6MjA3MTU0MDU4N30.C3UxcyWe3HRx9rG_ie7rkxjU95TvbZZydcZjEqgeovU"));
		} catch (Exception e) {
			return responseError(new ResponseBean(e.getMessage()), e);
		}

	}



}
