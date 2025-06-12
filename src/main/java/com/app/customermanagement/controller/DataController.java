package com.app.customermanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.MasterData;
import com.app.customermanagement.service.CustomerService;
import com.app.customermanagement.service.MasterDataService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/masterdata")
@AllArgsConstructor
@CrossOrigin("*")
public class DataController extends BaseController{
	
	public final MasterDataService masterDataService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(
			@RequestParam(name = "key") String key
			){
		try {
			ResponseBean responseBean = new ResponseBean();
			Map<String, List<MasterData>> groupedData = new HashMap();
			groupedData.put("status", masterDataService.getDataByKey(key));
			groupedData.put("location", masterDataService.getDataByKey("location"));
			responseBean.setData(groupedData);
			return response(responseBean);
		}catch(Exception e) {
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
