package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.AppConfig;
import com.app.customermanagement.service.AppConfigService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/config")
@AllArgsConstructor
@CrossOrigin("*")
public class AppConfigController extends BaseController {
	
	private final AppConfigService appConfigService;
	
	@GetMapping("/get")
	public ResponseEntity<?> checkCustomer(
			@RequestParam String key
			){
		try {
			return response(new ResponseBean(appConfigService.getByKey(key)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return responseError(new ResponseBean(e.getMessage()), e);
		}	
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody AppConfig config){
		try {
			return response(new ResponseBean(appConfigService.add(config)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody AppConfig config){
		try {
			return response(new ResponseBean(appConfigService.add(config)));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody AppConfig config){
		try {
			appConfigService.delete(config);
			return response(new ResponseBean(CommonConstant.OK));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}