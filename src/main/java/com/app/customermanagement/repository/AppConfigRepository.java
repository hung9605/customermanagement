package com.app.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.customermanagement.model.AppConfig;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig,Integer>  {
	
	AppConfig findByConfigKey(String configKey);

}
