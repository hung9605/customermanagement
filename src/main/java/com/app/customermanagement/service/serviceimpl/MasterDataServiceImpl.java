package com.app.customermanagement.service.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.model.MasterData;
import com.app.customermanagement.repository.MasterDataRepository;
import com.app.customermanagement.service.MasterDataService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MasterDataServiceImpl implements MasterDataService{
	
	public final MasterDataRepository masterDataRepository;

	@Override
	public List<MasterData> getDataByKey(String key) throws Exception {
		return masterDataRepository.findByKeyData(key);
	}

}
