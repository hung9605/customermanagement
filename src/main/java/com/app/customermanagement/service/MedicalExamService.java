package com.app.customermanagement.service;

import com.app.customermanagement.dto.model.MoneyDetail;
import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;

import java.util.List;

public interface MedicalExamService {
    MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) throws Exception;
    MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination);
    List<MedicalExamination> getListByCustormer(Customer customer);
    MedicalExamination getByIdSchedule(ScheduleMedical sMedical);
    List<MoneyDto> listMoney(Integer page, String date, String toDate);
    List<MoneyDetail> listMoneyExport(Integer page, String date, String toDate) throws  Exception;
}
