package com.app.customermanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.customermanagement.dto.model.MoneyDetail;
import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;

import jakarta.transaction.Transactional;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination,Integer> {
	
	MedicalExamination findByMedical(ScheduleMedical medical);

	
	@Query("select new com.app.customermanagement.dto.model.MoneyDto(se.id,se.fullName,se.dateRegister,me.totalMoney,me.status,me.id)from MedicalExamination me " +
			"inner join ScheduleMedical se on me.medical.id = se.id where me.dayOfExamination >= :date and me.dayOfExamination <= :toDate")
	List<MoneyDto> listMoney(String date, String toDate);


	@Query("select new com.app.customermanagement.dto.model.MoneyDetail(m.id,sm.fullName, m.dayOfExamination,m.status,p.quantity,s.medicineName \n" +
			"  ,s.unitPrice,m.totalMoney) from MedicalExamination m \n" +
			"  inner join ScheduleMedical sm on m.medical.id  = sm.id \n" +
			" inner join Prescription p  on m.id = p.medicalExamination.id \n" +
			"inner join MedicalSupplies s on p.medicalSupplies.id  = s.id \n" +
			"where  m.dayOfExamination BETWEEN :fromDate AND  :toDate")
	List<MoneyDetail> listMoneyExport(String fromDate, String toDate);
	
	
	
}
