package com.app.customermanagement.service;

import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;

import java.util.List;

public interface MedicalExamService {
    MedicalExamination addMedicalExamination(MedicalExamination medicalExamination);
    MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination);
    List<MedicalExamination> getListByCustormer(Customer customer);
    MedicalExamination getByIdSchedule(ScheduleMedical sMedical);
}
