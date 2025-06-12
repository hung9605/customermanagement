package com.app.customermanagement.service;

import java.util.List;

import com.app.customermanagement.model.MasterData;

public interface MasterDataService {

	List<MasterData> getDataByKey(String key) throws Exception;
	
}
