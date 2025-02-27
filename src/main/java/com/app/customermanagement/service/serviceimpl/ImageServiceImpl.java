package com.app.customermanagement.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.ImageDto;
import com.app.customermanagement.model.Image;
import com.app.customermanagement.repository.ImageRepository;
import com.app.customermanagement.service.ImageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private final ImageRepository imageRepository;
	private final String HTTP_IMAGE = "http://localhost:8085/api/upload/images/";

	@Override
	public List<ImageDto> getImage(Integer suppliesId) {
		// TODO Auto-generated method stub
		List<Image> lstImage =  imageRepository.findBySuppliesId(suppliesId);
		List<ImageDto> lstImageDtos = new ArrayList<>();
		lstImage.stream().forEach(item ->{
			String link = HTTP_IMAGE + item.getFolderName() + CommonConstant.SLASH + item.getFileName();
			ImageDto imageDto = new ImageDto(link, link, "", "");
			lstImageDtos.add(imageDto);
		});
		return lstImageDtos;
	}

	@Override
	public Image addImage(Image image) {
		// TODO Auto-generated method stub
		return imageRepository.save(image);
	}

	@Override
	public List<Image> addAll(List<Image> lstImages) {
		// TODO Auto-generated method stub
		return imageRepository.saveAll(lstImages);
	}

}
