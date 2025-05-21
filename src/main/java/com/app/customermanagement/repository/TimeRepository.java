package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer>{
	
	List<Time> findByStatusFalse();
	
	@Modifying
    @Transactional  // Đảm bảo rằng phương thức này sẽ thực hiện trong một transaction
    @Query("UPDATE Time t SET t.status = false")
    void updateAllStatusToFalse();
	
	@Modifying
    @Transactional  // Đảm bảo rằng phương thức này sẽ thực hiện trong một transaction
    @Query("UPDATE Time t SET t.status = true where t.time = :time")
	void updateTimeisRegister(String time);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Time")
	void deleteAllTimes();


}