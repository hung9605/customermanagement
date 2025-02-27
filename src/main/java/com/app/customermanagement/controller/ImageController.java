package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.ImageService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController  extends BaseController{
	
	public final ImageService imageService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(@RequestParam(required = true) Integer suppliesId){
		try {
			return response(new ResponseBean(imageService.getImage(suppliesId)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
