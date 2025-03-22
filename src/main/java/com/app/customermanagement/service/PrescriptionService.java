package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.PrescriptionDto;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.Prescription;

public interface PrescriptionService {
	
	Prescription add(Prescription prescription) throws Exception;
	Prescription update(Prescription prescription) throws Exception;
	List<Prescription> addAll(List<Prescription> lstPrescriptions) throws Exception;
	List<Prescription> list(MedicalExamination medicalExamination) throws Exception;
	List<PrescriptionDto> getListSupplies(Integer id) throws Exception;
}
