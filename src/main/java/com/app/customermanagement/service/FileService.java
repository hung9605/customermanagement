package com.app.customermanagement.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	void uploadFile(MultipartFile file) throws Exception;
}
