package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.model.Ogranization;

public interface OgranizationService {
	
	Ogranization save(Ogranization ogranization) throws Exception;
	List<Ogranization> findAll() throws Exception;
	Integer update(Ogranization ogranization) throws Exception;
	void delete(Ogranization ogranization) throws Exception;

}
