package com.app.customermanagement.service;

import com.app.customermanagement.model.MedicalExamination;

import java.util.List;

public interface MedicalExamService {
    MedicalExamination addMedicalExamination(MedicalExamination medicalExamination);
    MedicalExamination getMedicalExamination(Integer medicalExaminationId);
    List<MedicalExamination> getAllMedicalExaminations();
    MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination);

}
