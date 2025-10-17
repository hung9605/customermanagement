package com.app.customermanagement.service.serviceimpl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.model.AppConfig;
import com.app.customermanagement.repository.AppConfigRepository;
import com.app.customermanagement.service.AppConfigService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppConfigServiceImpl implements AppConfigService {
	
	private final AppConfigRepository appConfigRepository;
	private final ParamConfig paramConfig;
	private Map<String, String> cache = new HashMap<>();

	@PostConstruct
    public void loadAll() {
        cache = appConfigRepository.findAll()
                    .stream()
                    .collect(Collectors.toMap(AppConfig::getConfigKey, AppConfig::getConfigValue));
    }

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
		config = appConfigRepository.saveAll(config);
		syncToParamConfig(config);
		return config;
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
	
	public String get(String key) {
		return cache.get(key);
	}
	
	  private void syncToParamConfig(List<AppConfig> configs) {
	        Class<?> clazz = paramConfig.getClass();

	        for (AppConfig config : configs) {
	            try {
	                String key = config.getConfigKey();
	                String value = config.getConfigValue();
	                Field field = clazz.getDeclaredField(key);
	                field.setAccessible(true);
	                if (field.getType().equals(Integer.class)) {
	                    field.set(paramConfig, Integer.valueOf(value));
	                } else {
	                    field.set(paramConfig, value);
	                }
	            } catch (NoSuchFieldException e) {
	                System.out.println("No field in ParamConfig for key: " + config.getConfigKey());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

}