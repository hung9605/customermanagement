package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.model.AppConfig;

public interface AppConfigService {
	
	Object getByKey(String key) throws Exception;
	List<AppConfig> getAll() throws Exception;
	AppConfig add(AppConfig config) throws Exception;
	List<AppConfig> update(List<AppConfig> config) throws Exception;
	void delete(AppConfig config) throws Exception;
}
