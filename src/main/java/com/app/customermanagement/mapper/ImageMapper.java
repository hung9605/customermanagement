//package com.app.customermanagement.mapper;
//
//import java.util.List;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.app.customermanagement.dto.model.ImageDto;
//import com.app.customermanagement.model.Image;
//
//@Mapper
//public interface ImageMapper {
//	
//
//	
//	@Mapping(target = "folderName", expression = "java(addBasePath(imageDto.getFolderName()))")
//	@Mapping(target = "fileName", source = "thumbnailImageSrc")
//	Image mapToModel(ImageDto imageDto);
//	@Mapping(source = "folderName", target = "itemImageSrc")
//	@Mapping(source = "fileName", target = "thumbnailImageSrc")
//	ImageDto maptoDto(Image image);
//	List<Image> mapToModels(List<ImageDto> lstDto);
//	List<ImageDto> maptoDtos(List<Image> lstModel);
//	
//	// Custom method to add base path logic
//    default String addBasePath(String folderName) {
//        return getBasePath() + folderName;
//    }
//
//}