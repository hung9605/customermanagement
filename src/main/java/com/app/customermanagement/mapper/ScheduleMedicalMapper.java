package com.app.customermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.model.ScheduleMedical;

@Mapper
public interface ScheduleMedicalMapper {
	
	ScheduleMedical maptoModel(ScheduleDto dto);
	@Mapping(target = "phoneNumber", source = "customer.phoneNumber")
	ScheduleDto mapToDto(ScheduleMedical medical);
	List<ScheduleMedical> mapToModels(List<ScheduleDto> dtos);
	List<ScheduleDto> mapToDtos(List<ScheduleMedical> models);

}