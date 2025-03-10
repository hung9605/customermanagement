package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Time;

public interface TimeRepository extends JpaRepository<Time, Integer>{

}
