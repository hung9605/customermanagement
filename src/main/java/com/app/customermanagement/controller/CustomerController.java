package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.model.CustomerDto;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerController extends BaseController{
	
	private final CustomerService customerService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(name = "name") String name
			){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.searchCustomerFirstNameOrMidNameOrLastName(name));
		return response(responseBean);
	}
	
	@GetMapping("/checkcustomer")
	public ResponseEntity<?> checkCustomer(
			@RequestParam String firstName
			,@RequestParam String midName
			,@RequestParam String lastName
			,@RequestParam String phoneNumber
			){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(firstName,midName,lastName,phoneNumber));
		return response(responseBean);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CustomerDto customer){
		customerService.refreshCache();
		return response(new ResponseBean(customerService.addCustomer(customer)));
	}
	
	@GetMapping("/listcustomer")
	public ResponseEntity<?> listcustomer(
			@RequestParam(defaultValue = "0") int page){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.list(page));						
		return response(responseBean);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CustomerDto customer){
		return response(new ResponseBean(customerService.updateCustomer(customer)));
	}
	
	@PostMapping("/updatename")
	public ResponseEntity<?> updateName(@RequestBody CustomerDto customer){
		return response(new ResponseBean(customerService.updateName(customer)));
	}
	
	
	
}
