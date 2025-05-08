package com.app.customermanagement.repository;

import java.util.List;

import com.app.customermanagement.dto.model.ExamDetail;

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
	List<ScheduleMedical> findByCustomerAndStatusTrue(Customer customerOpt);
	ScheduleMedical findByTimeRegisterAndDateRegister(String timeRegister,String date);
	
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

}
