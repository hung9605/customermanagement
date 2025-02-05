package com.app.customermanagement.repository;

import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination,Integer> {
	
	MedicalExamination findByMedical(ScheduleMedical medical);

	@Query("select new com.app.customermanagement.dto.model.MoneyDto(se.id,se.fullName,se.dateRegister,me.totalMoney,me.status) from MedicalExamination me " +
			"inner join ScheduleMedical se on me.medical.id = se.id where me.dayOfExamination >= :date and me.dayOfExamination <= :toDate")
	List<MoneyDto> listMoney(String date, String toDate);
	
}
