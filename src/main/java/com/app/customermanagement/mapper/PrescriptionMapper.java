package com.app.customermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.app.customermanagement.dto.model.PrescriptionDto;
import com.app.customermanagement.model.Prescription;

@Mapper(componentModel = "spring")
public interface PrescriptionMapper {
	PrescriptionDto maptoDto(Prescription model);
	Prescription maptoModel(PrescriptionDto dto);
	List<PrescriptionDto> maptoDtos(List<Prescription> models);
	List<Prescription> maptoModels(List<PrescriptionDto> dtos);
}
