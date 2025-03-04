package com.app.customermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.app.customermanagement.model.MedicalSupplies;

public interface MedicalSuppliesRepository extends JpaRepository<MedicalSupplies, Integer> {
	
	MedicalSupplies findByMedicineName(String medicineName);
	List<MedicalSupplies> findByIsDeleteFalse();
	Optional<MedicalSupplies> findById(Integer suppliesId);
	
	@Transactional
	@Modifying
	@Query("update MedicalSupplies m set m.isDelete = :isDelete where m.id = :id")
	void updateRemove(@Param("isDelete") Boolean isDelete, @Param("id") Integer id);
	
}