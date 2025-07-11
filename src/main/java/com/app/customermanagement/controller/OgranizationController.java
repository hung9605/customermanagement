package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.Ogranization;
import com.app.customermanagement.service.OgranizationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ogranization")
@CrossOrigin("*")
public class OgranizationController extends BaseController {
	
	private final OgranizationService ogranizationService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			return response(new ResponseBean(ogranizationService.findAll()));
		} catch (Exception e) {
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Ogranization ogranization){
		try {
			return response(new ResponseBean(ogranizationService.save(ogranization)));
		} catch (Exception e) {
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Ogranization ogranization){
		try {
			return response(new ResponseBean(ogranizationService.update(ogranization)));
		} catch (Exception e) {
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Ogranization ogranization){
		try {
			ogranizationService.delete(ogranization);
			return response(new ResponseBean(CommonConstant.OK));
		} catch (Exception e) {
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
