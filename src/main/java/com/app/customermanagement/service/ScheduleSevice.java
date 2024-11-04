package com.app.customermanagement.service;

import com.app.customermanagement.model.ScheduleMedical;

import java.util.List;

public interface ScheduleSevice {
    ScheduleMedical register(ScheduleMedical scheduleMedical);
    ScheduleMedical updateScheduleMedical(ScheduleMedical scheduleMedical);
    List<ScheduleMedical> getAllScheduleMedicals();
    ScheduleMedical getScheduleMedicalById(Integer id);
}
