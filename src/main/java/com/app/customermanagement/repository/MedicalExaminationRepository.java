package com.app.customermanagement.repository;

import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination,Integer> {
	
	MedicalExamination findByMedical(ScheduleMedical medical);
	
}
