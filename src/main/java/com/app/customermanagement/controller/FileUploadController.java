package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.service.FileService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/upload")
@AllArgsConstructor
@CrossOrigin("*")
public class FileUploadController extends BaseController {

	   public final FileService fileService;

	    @PostMapping("/file")
	    public ResponseEntity<ResponseBean> uploadFile(@RequestParam("file") MultipartFile file) {
	        try {
	        	fileService.uploadFile(file);
	        	return response(new ResponseBean("Upload successfully !"));
	        } catch (Exception e) {
	            return responseError(new ResponseBean(e.getMessage()), e);
	        }
	    }
	


}
