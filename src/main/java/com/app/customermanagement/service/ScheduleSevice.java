package com.app.customermanagement.service;

import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.model.ScheduleMedical;

import java.util.List;

public interface ScheduleSevice {
    ScheduleMedical register(ScheduleMedical scheduleMedical);
    List<ScheduleMedical> getListByDay(String day);
    ScheduleMedical updateScheduleMedical(ScheduleMedical scheduleMedical);
    List<ScheduleMedical> getListByName( String name);
    List<ScheduleDto> getListRegister();
    List<ScheduleDto> getListHistory(String date);
}
