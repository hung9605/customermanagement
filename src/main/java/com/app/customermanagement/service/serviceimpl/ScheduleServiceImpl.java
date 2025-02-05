package com.app.customermanagement.service.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.mapper.ScheduleMedicalMapperImpl;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.ScheduleSevice;
import com.app.customermanagement.util.DateUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleSevice {
	
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	@Override
	public ScheduleMedical register(ScheduleDto scheduleDto) throws Exception {
		if(checkRegisterExists(scheduleDto.getFullName(), scheduleDto.getPhoneNumber()))
			throw new Exception("User Registered");
		if(!checkTimeRegister(scheduleDto.getTimeRegister()))
			throw new Exception("Time is exists!");
		ScheduleMedical scheduleMedical = new ScheduleMedicalMapperImpl().maptoModel(scheduleDto);
		scheduleMedical.setCreatedAt(new Date());
		scheduleMedical.setCreatedBy(CommonConstant.ADMIN);
		String dateRegister = DateUtils.formatDate(CommonConstant.DATE_PATTERN,new Date());
		scheduleMedical.setStatus(CommonConstant.NO_EXAMINED);
		scheduleMedical.setDateRegister(dateRegister);
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
		scheduleMedical.setStatus(CommonConstant.NO_EXAMINED);
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
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(dateRegister, CommonConstant.NO_EXAMINED);
		return new ScheduleMedicalMapperImpl().mapToDtos(sMedicals);
	}

	@Override
	public List<ScheduleDto> getListHistory(String date) {
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(date, CommonConstant.EXAMINED);
		return new ScheduleMedicalMapperImpl().mapToDtos(sMedicals);
	}

	@Override
	public ScheduleMedical registerV1(ScheduleMedical scheduleMedical) {

		return null;
	}

	@Override
	public boolean checkRegisterExists(String fullName,String phoneNumber) {
		// TODO Auto-generated method stub
		List<ScheduleDto> listRegister = getListRegister();
		List<ScheduleDto> listCheck = listRegister.stream().filter( item ->{
			return fullName.equals(item.getFullName()) && phoneNumber.equals(item.getPhoneNumber());
		}
		).collect(Collectors.toList());
		return listCheck.size() > 0 ;
	}

	@Override
	public List<ScheduleDto> getListHistory(String formDate, String toDate) {
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterBetweenAndStatusOrderByTimeRegister(formDate,toDate, CommonConstant.EXAMINED);
		return new ScheduleMedicalMapperImpl().mapToDtos(sMedicals);
	}

	@Override
	public boolean checkTimeRegister(String time) {
		// TODO Auto-generated method stub
		return null == scheduleMedicalRepository.findByTimeRegisterAndDateRegister(time,DateUtils.formatDate(CommonConstant.DATE_PATTERN, new Date()));
	}
   


}
