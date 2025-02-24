package com.app.customermanagement.controller;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	    
//	    @GetMapping("/images/{imageName}")
//	    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
//	        try {
//	            Path imagePath = imageLocation.resolve(imageName).normalize();
//	            Resource resource = new UrlResource(imagePath.toUri());
//
//	            if (resource.exists()) {
//	                // Lấy đúng Content-Type của file ảnh
//	                String contentType = Files.probeContentType(imagePath);
//	                return ResponseEntity.ok()
//	                        .header(HttpHeaders.CONTENT_TYPE, contentType)
//	                        .body(resource);
//	            } else {
//	                return ResponseEntity.notFound().build();
//	            }
//	        } catch (Exception e) {
//	            return ResponseEntity.status(500).body(null);
//	        }
//	    }
	


}
