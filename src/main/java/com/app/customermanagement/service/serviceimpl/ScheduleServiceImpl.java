package com.app.customermanagement.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.ExamDetail;
import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.mapper.ScheduleMedicalMapper;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.repository.TimeRepository;
import com.app.customermanagement.service.ScheduleSevice;
import com.app.customermanagement.util.DateUtils;
import com.app.customermanagement.util.StringUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleSevice {
	
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final TimeRepository timeRepository;
	private final ScheduleMedicalMapper scheduleMedicalMapper;
	private final MessageSource messageSource;
	
	@Override
	public ScheduleMedical register(ScheduleDto scheduleDto) throws Exception {
		if(checkRegisterExists(scheduleDto.getFullName(), scheduleDto.getPhoneNumber()))
			throw new Exception("Registration already exists for today !");
		ScheduleMedical scheduleMedical = scheduleMedicalMapper.maptoModel(scheduleDto);
		String dateRegister = DateUtils.formatDate(CommonConstant.DATE_PATTERN,new Date());
		scheduleMedical.setStatus(CommonConstant.NO_EXAMINED);
		scheduleMedical.setDateRegister(dateRegister);
		timeRepository.updateTimeisRegister(scheduleDto.getTimeRegister());
		return scheduleMedicalRepository.save(scheduleMedical);
	}

	/**
	 * @param scheduleDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public ScheduleMedical registerExistsCustomer(ScheduleDto scheduleDto) throws Exception {
		ScheduleMedical scheduleMedical = scheduleMedicalMapper.maptoModel(scheduleDto);
		
		String dateRegister = DateUtils.formatDate(CommonConstant.DATE_PATTERN,new Date());
		if(scheduleMedicalRepository.existsByCustomerAndDateRegister(scheduleDto.getCustomer(),dateRegister)) {
			throw new Exception(StringUtils.getMessage(messageSource,"error.schedule.exists"));
		};
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
	public Integer updateScheduleMedical(ScheduleDto scheduleDto) {
		// TODO Auto-generated method stub
		
		return scheduleMedicalRepository.updateSchedule(scheduleDto.getFullName(), scheduleDto.getTimeRegister(), scheduleDto.getId());
	}

	@Override
	public List<ScheduleMedical> getListByName(String name,String day) {
		// TODO Auto-generated method stub
		return scheduleMedicalRepository.findByFullNameAndDateRegister(name, day);
	}

	@Override
	public List<ScheduleDto> getListRegister() {
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(getToday(), CommonConstant.NO_EXAMINED);
		return scheduleMedicalMapper.mapToDtos(sMedicals);
	}

	@Override
	public List<ScheduleDto> getListHistory(String date) {
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterAndStatusOrderByTimeRegister(date, CommonConstant.EXAMINED);
		return scheduleMedicalMapper.mapToDtos(sMedicals);
	}

	@Override
	public ScheduleMedical registerV1(ScheduleMedical scheduleMedical) {

		return null;
	}

	@Override
	public boolean checkRegisterExists(String fullName,String phoneNumber) {
		// TODO Auto-generated method stub
//		List<ScheduleDto> listRegister = getListRegister();
//		List<ScheduleDto> listCheck = listRegister.stream().filter( item ->{
//			return fullName.equals(item.getFullName()) && phoneNumber.equals(item.getPhoneNumber());
//		}
//		).collect(Collectors.toList());
//		return listCheck.size() > 0 ;
		
		return getListRegister().stream()
			    .anyMatch(item -> fullName.equals(item.getFullName()) && phoneNumber.equals(item.getPhoneNumber()));

	}

	@Cacheable(value = "historyCache", key = "#formDate + '_' + #toDate")
	@Override
	public List<ScheduleDto> getListHistory(String formDate, String toDate) {
		List<ScheduleMedical> sMedicals = scheduleMedicalRepository.findByDateRegisterBetweenAndStatusOrderByTimeRegister(formDate,toDate, CommonConstant.EXAMINED);
		return scheduleMedicalMapper.mapToDtos(sMedicals);
	}

	@Override
	public boolean checkTimeRegister(String time) {
		// TODO Auto-generated method stub
	    return !scheduleMedicalRepository.existsByTimeRegisterAndDateRegister(time, getToday());
	}

	@Cacheable(value = "historyCache1", key = "#date + '_' + #toDate")
	@Override
	public List<ScheduleDto> getListMedicalHistory(Customer customer) {
		// TODO Auto-generated method stub
		return scheduleMedicalMapper.mapToDtos(scheduleMedicalRepository.findByCustomerAndStatusTrue(customer));
		
	}

	/**
	 * @param formDate
	 * @param toDate
	 * @return
	 */
	@Cacheable(value = "historyExportCache", key = "#formDate + '_' + #toDate")
	@Override
	public List<ExamDetail> getListHistoryExport(String formDate, String toDate) {
		return scheduleMedicalRepository.getListHistory(formDate,toDate);
	}

	
	@Override
	public List<ScheduleDto> getListRegisterAll(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return scheduleMedicalMapper.mapToDtos(scheduleMedicalRepository.findByDateRegisterBetweenOrderByTimeRegisterAscDateRegisterDesc(fromDate, toDate));
	}
	
	private String getToday() {
	    return DateUtils.formatDate(CommonConstant.DATE_PATTERN, new Date());
	}



}
