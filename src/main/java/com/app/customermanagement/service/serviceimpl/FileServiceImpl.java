package com.app.customermanagement.service.serviceimpl;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.service.FileService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class FileServiceImpl implements FileService{
	
	public final ParamConfig paramConfig;

	@Override
	public void uploadFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new  Exception("File is not exists!");
        }
        String fileName = file.getOriginalFilename();
        String uploadDir = paramConfig.getUrlUpload();
        Path path = Paths.get(uploadDir + fileName);
        file.transferTo(path);
	}

	@Override
	public Resource getImage(String imageName) throws MalformedURLException {
		Path imagePath = Paths.get(paramConfig.getUrlUpload()).resolve(imageName).normalize();
		return new UrlResource(imagePath.toUri());
	}

}
