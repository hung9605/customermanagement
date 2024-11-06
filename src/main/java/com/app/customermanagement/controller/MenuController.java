package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.model.MenuDto;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.MenuService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
public class MenuController extends BaseController{
	
	private final MenuService menuService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		return response(new ResponseBean(menuService.getAll()));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody MenuDto mDto){
		return response(new ResponseBean(menuService.addMenu(mDto)));
	}
}
