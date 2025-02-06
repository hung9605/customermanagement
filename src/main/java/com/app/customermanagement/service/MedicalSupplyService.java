package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.model.MedicalSupplies;

public interface MedicalSupplyService {
	
	MedicalSupplies add(MedicalSupplies medicalSupplies) throws Exception;
	List<MedicalSupplies> listMedicalSupplies() throws Exception;
	MedicalSupplies update(MedicalSupplies medicalSupplies) throws Exception;
	MedicalSupplies remove(MedicalSupplies medicalSupplies) throws Exception;
}
