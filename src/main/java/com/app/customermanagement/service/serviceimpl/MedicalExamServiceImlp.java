package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.MedicalExaminationRepository;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.MedicalExamService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalExamServiceImlp implements MedicalExamService {
	
	private final MedicalExaminationRepository medicalExaminationRepository;
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	
    @Override
    public MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) {
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	ScheduleMedical scheduleMedical = scheduleMedicalRepository.findById(mExamination.getMedical().getId()).get();
    	scheduleMedical.setStatus(CommonConstant.EXAMINED);
    	scheduleMedicalRepository.save(scheduleMedical);
        return mExamination;
    }

 
    @Override
    public MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination) {
        return medicalExaminationRepository.save(medicalExamination);
    }


	@Override
	public List<MedicalExamination> getListByCustormer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MedicalExamination getByIdSchedule(ScheduleMedical sMedical) {
		// TODO Auto-generated method stub
		return medicalExaminationRepository.findByMedical(sMedical);
	}
}