package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

}
