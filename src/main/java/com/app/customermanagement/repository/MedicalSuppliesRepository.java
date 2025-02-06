package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.MedicalSupplies;

public interface MedicalSuppliesRepository extends JpaRepository<MedicalSupplies, Integer> {

}
