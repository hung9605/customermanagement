package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.model.AppConfig;
import com.app.customermanagement.repository.AppConfigRepository;
import com.app.customermanagement.service.AppConfigService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppConfigServiceImpl implements AppConfigService {
	
	private final AppConfigRepository appConfigRepository;

	@Override
	public Object getByKey(String key) throws Exception {
		return appConfigRepository.findByConfigKey(key);
	}

	@Override
	public AppConfig add(AppConfig config) throws Exception {
		// TODO Auto-generated method stub
		return appConfigRepository.save(config);
	}

	@Override
	public List<AppConfig> update(List<AppConfig> config) throws Exception {
		// TODO Auto-generated method stub
		return appConfigRepository.saveAll(config);
	}

	@Override
	public void delete(AppConfig config) throws Exception {
	      appConfigRepository.delete(config);	
	}

	@Override
	public List<AppConfig> getAll() throws Exception {
		// TODO Auto-generated method stub
		return appConfigRepository.findAll();
	}

}