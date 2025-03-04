package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.dto.model.SuppliesListDto;
import com.app.customermanagement.model.MedicalSupplies;

public interface MedicalSupplyService {
	
	MedicalSupplies add(MedicalSupplies medicalSupplies) throws Exception;
	List<SuppliesListDto> listMedicalSupplies() throws Exception;
	MedicalSupplies update(MedicalSupplies medicalSupplies) throws Exception;
	void remove(MedicalSupplies medicalSupplies) throws Exception;
	MedicalSupplies getSupplies(String medicineName) throws Exception;
	MedicalSupplies getDetailSupplies(Integer suppliesId) throws Exception;
}