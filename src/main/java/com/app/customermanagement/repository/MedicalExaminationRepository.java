package com.app.customermanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.customermanagement.dto.model.MoneyDetail;
import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.dto.response.AccountChartDto;
import com.app.customermanagement.dto.response.HistoryChartDto;
import com.app.customermanagement.dto.response.Money;
import com.app.customermanagement.dto.response.MoneyChartDto;
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
	
	@Query(value = "select  \n"
			+ "	date_format(created_at,'%M') as `month` \n"
			+ "    ,sum(total_money) as `total_money` \n"
			+ " from medical_examination \n"
			+ " where year(created_at) = year(curdate()) \n"
			+ " group by date_format(created_at,'%M');",
      nativeQuery = true)
	List<Money> getDataDashBoardMoney();
	
	@Query(value = " select monthname(created_at) as `month`,sum(total_money) as `total` from medical_examination\r\n"
			+ "where day_of_examination between :fromDate and :toDate \r\n"
			+ "group by monthname(created_at),month(created_at)\r\n"
			+ "order by month(created_at);",
      nativeQuery = true)
	List<MoneyChartDto> getDataChartMoney(String fromDate, String toDate);
	
	
}
