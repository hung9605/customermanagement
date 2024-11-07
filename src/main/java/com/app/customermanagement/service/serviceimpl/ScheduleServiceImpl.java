package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.mapper.ScheduleMedicalMapperImpl;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.ScheduleSevice;
import com.app.customermanagement.util.DateUtils;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleSevice {
	
	private final ScheduleMedicalRepository scheduleMedicalRepository;

	@Override
	public ScheduleMedical register(ScheduleMedical scheduleMedical) {
		scheduleMedical.setCreatedAt(new Date());
		scheduleMedical.setCreatedBy(CommonConstant.ADMIN);
		scheduleMedical.setStatus(0);
		return scheduleMedicalRepository.save(scheduleMedical);
	}

	@Override
	public List<ScheduleMedical> getListByDay(String day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduleMedical updateScheduleMedical(ScheduleMedical scheduleMedical) {
		// TODO Auto-generated method stub
		return scheduleMedicalRepository.save(scheduleMedical);
	}

	@Override
	public List<ScheduleMedical> getListByName(String name,String day) {
		// TODO Auto-generated method stub
		return scheduleMedicalRepository.findByFullNameAndDateRegister(name, day);
	}

	@Override
	public List<ScheduleDto> getListRegister() {
		String dateRegister = DateUtils.formatDate(CommonConstant.DATE_PATTERN, new Date());
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(dateRegister, CommonConstant.NOT_EXAMINED);
		return new ScheduleMedicalMapperImpl().mapToDtos(sMedicals);
	}

	@Override
	public List<ScheduleDto> getListHistory(String date) {
		String dateRegister = DateUtils.formatDate(CommonConstant.DATE_PATTERN, new Date());
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(dateRegister, CommonConstant.EXAMINED);
		return new ScheduleMedicalMapperImpl().mapToDtos(sMedicals);
	}
   


}
