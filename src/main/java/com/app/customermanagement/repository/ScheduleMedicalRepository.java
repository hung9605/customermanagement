package com.app.customermanagement.repository;

import java.util.List;

import com.app.customermanagement.dto.model.ExamDetail;
import com.app.customermanagement.dto.response.Examination;
import com.app.customermanagement.dto.response.HistoryChartDto;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.ScheduleMedical;


public interface ScheduleMedicalRepository extends JpaRepository<ScheduleMedical, Integer> {
	
	@EntityGraph(attributePaths = {"customer", "customer.gender"})
	List<ScheduleMedical> findByDateRegisterAndStatusOrderByTimeRegister(String date,Integer status);
	@EntityGraph(attributePaths = {"customer", "customer.gender"})
	List<ScheduleMedical> findByDateRegisterBetweenAndStatusOrderByTimeRegister(String startDate, String endDate, Integer status);
	List<ScheduleMedical> findByFullNameAndDateRegister(String name,String date);
	ScheduleMedical findByFullNameContainingIgnoreCase(String fullName);
	@EntityGraph(attributePaths = {"customer"})
	List<ScheduleMedical> findByCustomerAndStatusTrue(Customer customerOpt);
	ScheduleMedical findByTimeRegisterAndDateRegister(String timeRegister,String date);
	boolean existsByTimeRegisterAndDateRegister(String timeRegister, String dateRegister);
	@Transactional
	@Modifying
	@Query("UPDATE ScheduleMedical s SET s.fullName = :fullName, s.timeRegister = :timeRegister WHERE s.id = :id")
	int updateSchedule(@Param("fullName") String fullName, @Param("timeRegister") String timeRegister, @Param("id") Integer id);

	@Query("select new com.app.customermanagement.dto.model.ExamDetail (" +
			"   s.id,s.fullName,s.dateRegister,s.timeRegister,m.timeActual,s.status,m.temperature,\n" +
			"   m.healthCondition,m.sympton,m.typeOfMedicine,m.totalMoney,s.createdAt,s.createdBy,\n" +
			"   m.updatedAt,m.updatedBy ) from ScheduleMedical s \n" +
			"   inner join MedicalExamination m on s.id = m.medical.id \n" +
			"   where s.dateRegister BETWEEN :startDate AND  :endDate ")
	List<ExamDetail> getListHistory(String startDate, String endDate);
	
	boolean existsByCustomerAndDateRegister(Customer customer, String dateRegister);
	
	@EntityGraph(attributePaths = {"customer", "customer.gender"})
	List<ScheduleMedical> findByDateRegisterBetweenOrderByTimeRegisterAscDateRegisterDesc(String startDate, String endDate);
	
	@Query(value = "SELECT \n"
			+ "    DATE_FORMAT(created_at, '%Y-%m') AS `month`, \n"
			+ "    COUNT(id) AS `total`, \n"
			+ "    SUM(CASE WHEN status = 1 THEN 1 ELSE 0 END) AS `number_exam`, \n"
			+ "    SUM(CASE WHEN status = 0 THEN 1 ELSE 0 END) AS `number_not_exam` \n"
			+ "FROM schedule_medical \n"
			+ "WHERE YEAR(created_at) = YEAR(CURDATE())   -- chỉ lấy trong năm hiện tại \n"
			+ "GROUP BY DATE_FORMAT(created_at, '%Y-%m') \n"
			+ "ORDER BY `month` ASC;",
      nativeQuery = true)
	List<Examination> getDataDashBoardExam();
	
	@Query(value = "select \r\n"
			+ "	count(id) as 'total'\r\n"
			+ "	,monthname(created_at) as 'month'\r\n"
			+ " from schedule_medical\r\n"
			+ " where date_register between :fromDate and :toDate \r\n"
			+ " group by monthname(created_at),month(created_at)\r\n"
			+ " order by month(created_at);",
      nativeQuery = true)
	List<HistoryChartDto> getDataChart(@Param("fromDate") String fromDate,@Param("toDate") String toDate);



}
