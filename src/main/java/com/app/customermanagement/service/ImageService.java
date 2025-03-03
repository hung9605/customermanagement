package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.ImageDto;
import com.app.customermanagement.model.Image;

public interface ImageService {
	
	List<ImageDto> getImage(Integer suppliesId);
	Image addImage(Image image);
	List<Image> addAll(List<Image> lstImages);
	void remove(List<ImageDto> imageDto) throws Exception;

}
