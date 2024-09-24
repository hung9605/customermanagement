package com.app.customermanagement.repository;

import com.app.customermanagement.model.ScheduleMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleMedicalRepository extends JpaRepository<ScheduleMedical, Integer> {
}
