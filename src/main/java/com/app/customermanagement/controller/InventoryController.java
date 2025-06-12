package com.app.customermanagement.controller;

import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.InventoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
public class InventoryController extends BaseController {
	
	private final InventoryService inventoryService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			return response(new ResponseBean( inventoryService.fetchInventoryWithMedicalSupplies()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Inventory inventory){
		try {
			return response(new ResponseBean(inventoryService.add(inventory)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
