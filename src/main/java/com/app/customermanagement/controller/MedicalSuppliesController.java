package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.service.MedicalSupplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalsupplies")
@CrossOrigin("*")
public class MedicalSuppliesController extends BaseController{
	
	private final MedicalSupplyService medicalSupplyService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody MedicalSupplies medicalSupplies){
		try {
			return response(new ResponseBean(medicalSupplyService.add(medicalSupplies)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	


	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			return response(new ResponseBean(medicalSupplyService.listMedicalSupplies()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
