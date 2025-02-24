package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.ScheduleMedical;


public interface ScheduleMedicalRepository extends JpaRepository<ScheduleMedical, Integer> {
	
	List<ScheduleMedical> findByDateRegisterAndStatusOrderByTimeRegister(String date,Integer status);
	List<ScheduleMedical> findByDateRegisterBetweenAndStatusOrderByTimeRegister(String startDate, String endDate, Integer status);
	List<ScheduleMedical> findByFullNameAndDateRegister(String name,String date);
	ScheduleMedical findByFullNameContainingIgnoreCase(String fullName);
	ScheduleMedical findByCustomer(Customer customerOpt);
	ScheduleMedical findByTimeRegisterAndDateRegister(String timeRegister,String date);
	
	@Transactional
	@Modifying
	@Query("UPDATE ScheduleMedical s SET s.fullName = :fullName, s.timeRegister = :timeRegister WHERE s.id = :id")
	int updateSchedule(@Param("fullName") String fullName, @Param("timeRegister") String timeRegister, @Param("id") Integer id);


}
