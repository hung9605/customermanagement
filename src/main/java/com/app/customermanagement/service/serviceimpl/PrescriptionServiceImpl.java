package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.dto.model.PrescriptionDto;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.Prescription;
import com.app.customermanagement.repository.PrescriptionRepository;
import com.app.customermanagement.service.PrescriptionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {
	
	private final PrescriptionRepository prescriptionRepository;

	@Override
	public Prescription add(Prescription prescription) throws Exception {
		// TODO Auto-generated method stub
		return prescriptionRepository.save(prescription);
	}

	@Override
	public Prescription update(Prescription prescription) throws Exception{
		// TODO Auto-generated method stub
		return prescriptionRepository.save(prescription);
	}

	@Override
	public List<Prescription> addAll(List<Prescription> lstPrescriptions) throws Exception {
		return prescriptionRepository.saveAll(lstPrescriptions);
	}

	@Override
	public List<Prescription> list(MedicalExamination medicalExamination) throws Exception {
		// TODO Auto-generated method stub
		return prescriptionRepository.findByMedicalExamination(medicalExamination);
	}

	@Override
	public List<PrescriptionDto> getListSupplies(Integer id) throws Exception {
		return prescriptionRepository.getList(id);
	}
}
