package com.app.customermanagement.service;

import com.app.customermanagement.dto.model.ExamDetail;
import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;
import java.util.List;

public interface ScheduleSevice {
    ScheduleMedical register(ScheduleDto scheduleDto) throws Exception;
    ScheduleMedical registerExistsCustomer(ScheduleDto scheduleDto) throws Exception;
    List<ScheduleMedical> getListByDay(String day);
    Integer updateScheduleMedical(ScheduleDto ScheduleDto);
    List<ScheduleMedical> getListByName(String name, String day);
    List<ScheduleDto> getListRegister();
    List<ScheduleDto> getListHistory(String date);
    List<ScheduleDto> getListHistory(String formDate, String toDate);
    ScheduleMedical registerV1(ScheduleMedical scheduleMedical);
    boolean checkRegisterExists(String fullName,String phoneNumber);
    boolean checkTimeRegister(String time);
    List<ScheduleDto> getListMedicalHistory(Customer customer);
    List<ExamDetail> getListHistoryExport(String formDate, String toDate);
    
    List<ScheduleDto> getListRegisterAll(String fromDate, String toDate);
}