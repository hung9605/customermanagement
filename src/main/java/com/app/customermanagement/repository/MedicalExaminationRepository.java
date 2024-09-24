package com.app.customermanagement.repository;

import com.app.customermanagement.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination,Integer> {
}
