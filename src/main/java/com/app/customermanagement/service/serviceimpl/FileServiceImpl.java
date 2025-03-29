package com.app.customermanagement.service.serviceimpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.ImageDto;
import com.app.customermanagement.model.Image;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.service.FileService;
import com.app.customermanagement.service.ImageService;
import com.app.customermanagement.service.MedicalSupplyService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class FileServiceImpl implements FileService{
	
	public final ParamConfig paramConfig;
	public final MedicalSupplyService medicalSupplyService;
	public final ImageService imageService;
	
	@Override
	public void uploadFile(MultipartFile file,String folderName) throws Exception {
        if (file.isEmpty()) {
            throw new  Exception("File is not exists!");
        }
        String fileName = file.getOriginalFilename();
        String uploadDir = paramConfig.getUrlUpload()+folderName+CommonConstant.SLASH;
        Path path = Paths.get(uploadDir + fileName);
        file.transferTo(path);
        //MedicalSupplies mSupplies = medicalSupplyService.getDetailSupplies(Integer.parseInt(folderName));
        Image image = new Image(0, folderName, fileName, Integer.parseInt(folderName));
        imageService.addImage(image);
	}

	@Override
	public Resource getImage(String imageName, String folderName) throws MalformedURLException {
		Resource uri = new ClassPathResource("upload");
        String folder = null;
        try {
            folder = uri.getURI().toString()+ CommonConstant.SLASH  +folderName + CommonConstant.SLASH;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(folder);
		Path imagePath = Paths.get(folder).resolve(imageName).normalize();
		return new UrlResource(imagePath.toUri());
	}

	@Override
	public void deleteFile(List<String> paths) throws Exception {
		// TODO Auto-generated method stub
			paths.stream().forEach(path -> {
			Path pathFile = Paths.get(paramConfig.getUrlUpload()+path);
			try {
				Files.delete(pathFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public void remove(List<ImageDto> imageDto) throws Exception {
		// TODO Auto-generated method stub
		List<String> paths = imageDto.stream().map(item -> {
			String url = item.getItemImageSrc();
			int index = url.indexOf("images/");
			return url.substring(index + "images/".length());
		}).collect(Collectors.toList());
		deleteFile(paths);	
	}
}