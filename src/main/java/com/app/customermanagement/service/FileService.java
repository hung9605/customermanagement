package com.app.customermanagement.service;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.app.customermanagement.dto.model.ImageDto;

public interface FileService {
	void uploadFile(MultipartFile file,String folderName) throws Exception;
	Resource getImage(String imageName,String folderName) throws MalformedURLException;
	void deleteFile(List<String> path) throws Exception;
	void remove(List<ImageDto> imageDto) throws Exception;
}
