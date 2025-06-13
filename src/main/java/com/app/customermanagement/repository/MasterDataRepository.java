package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.customermanagement.model.MasterData;

public interface MasterDataRepository extends JpaRepository<MasterData, Integer>{
	
	List<MasterData> findByKeyData(String key);
	
}
