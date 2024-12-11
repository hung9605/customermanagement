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
			@RequestParam(name = "page" , defaultValue = "0") int page,
			@RequestParam(name = "name") String name
			){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.searchCustomerFirstNameOrMidNameOrLastName(name));
		return response(responseBean);
	}
	
	@GetMapping("/checkcustomer")
	public ResponseEntity<?> checkCustomer(
			@RequestParam(name = "firstName") String firstName
			,@RequestParam(name = "midName") String midName
			,@RequestParam(name = "lastName") String lastName
			,@RequestParam(name = "phoneNumber") String phoneNumber
			){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.searchCustomerFirstNameAndMidNameAndLastNameAndPhoneNumber(firstName,midName,lastName,phoneNumber));
		return response(responseBean);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CustomerDto customer){
		return response(new ResponseBean(customerService.addCustomer(customer)));
	}
	
	@GetMapping("/listcustomer")
	public ResponseEntity<?> listcustomer(
			@RequestParam(name = "page" , defaultValue = "0") int page
			){
		ResponseBean responseBean = new ResponseBean();
		responseBean.setData(customerService.list(page));
		return response(responseBean);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CustomerDto customer){
		return response(new ResponseBean(customerService.updateCustomer(customer)));
	}
	
	
	
}
