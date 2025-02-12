package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {


	List<Prescription> findByMedicalExamination(MedicalExamination medicalExamination);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Prescription p WHERE p.medicalExamination = :medicalExamination")
	void deletePrescription(@Param("medicalExamination") MedicalExamination medicalExamination);
	
}
