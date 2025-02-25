package com.app.customermanagement.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ResourceBundle;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	void uploadFile(MultipartFile file) throws Exception;
	Resource getImage(String imageName) throws MalformedURLException;
}
