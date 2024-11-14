package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.customermanagement.model.ScheduleMedical;

@Repository
public interface ScheduleMedicalRepository extends JpaRepository<ScheduleMedical, Integer> {
	
	List<ScheduleMedical> findByDateRegisterAndStatusOrderByTimeRegister(String date,Integer status);
	List<ScheduleMedical> findByFullNameAndDateRegister(String name,String date);
}
