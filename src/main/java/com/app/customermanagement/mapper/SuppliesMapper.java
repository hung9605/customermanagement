package com.app.customermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.customermanagement.dto.model.SuppliesListDto;
import com.app.customermanagement.model.MedicalSupplies;

@Mapper(componentModel = "spring")
public interface SuppliesMapper {
	
	SuppliesListDto mapToDto(MedicalSupplies medicalSupplies);
	MedicalSupplies mapToModel(SuppliesListDto suppliesListDto);
	List<SuppliesListDto> mapToDtos(List<MedicalSupplies> medicalSupplies);
	List<MedicalSupplies> mapToModels(List<SuppliesListDto> suppliesListDto);

}
