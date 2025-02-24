package com.app.customermanagement.service;

import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.model.ScheduleMedical;
import java.util.List;

public interface ScheduleSevice {
    ScheduleMedical register(ScheduleDto scheduleDto) throws Exception;
    List<ScheduleMedical> getListByDay(String day);
    Integer updateScheduleMedical(ScheduleDto ScheduleDto);
    List<ScheduleMedical> getListByName(String name, String day);
    List<ScheduleDto> getListRegister();
    List<ScheduleDto> getListHistory(String date);
    List<ScheduleDto> getListHistory(String formDate, String toDate);
    ScheduleMedical registerV1(ScheduleMedical scheduleMedical);
    boolean checkRegisterExists(String fullName,String phoneNumber);
    boolean checkTimeRegister(String time);
}