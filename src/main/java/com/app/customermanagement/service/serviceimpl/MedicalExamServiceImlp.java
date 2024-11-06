package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.service.MedicalExamService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MedicalExamServiceImlp implements MedicalExamService {
    @Override
    public MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) {
        return null;
    }

 
    @Override
    public MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination) {
        return null;
    }


	@Override
	public List<MedicalExamination> getListByCustormer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MedicalExamination getByIdSchedule(ScheduleMedical sMedical) {
		// TODO Auto-generated method stub
		return null;
	}
}
