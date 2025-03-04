package com.app.customermanagement.service.serviceimpl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.SuppliesListDto;
import com.app.customermanagement.mapper.SuppliesMapperImpl;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.repository.MedicalSuppliesRepository;
import com.app.customermanagement.service.MedicalSupplyService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MedicalSuppliesServiceImpl implements MedicalSupplyService {
	
	private final MedicalSuppliesRepository medicalSuppliesRepository;
	private final ParamConfig paramConfig;

	@Override
	public MedicalSupplies add(MedicalSupplies medicalSupplies) throws Exception {
		// TODO Auto-generated method stub
		medicalSupplies.setId(null);
		medicalSupplies.setCreatedAt(new Date());
		medicalSupplies.setCreatedBy(CommonConstant.ADMIN);
		medicalSupplies.setStatus(true);
		medicalSupplies.setFolderName(medicalSupplies.getMedicineName());
		createFolder(medicalSupplies.getMedicineName());
		return medicalSuppliesRepository.save(medicalSupplies);
	}

	@Override
	public List<SuppliesListDto> listMedicalSupplies() throws Exception {
		// TODO Auto-generated method stub
		return new SuppliesMapperImpl().mapToDtos(medicalSuppliesRepository.findByIsDeleteFalse());
	}

	@Override
	public MedicalSupplies update(MedicalSupplies medicalSupplies) throws Exception {
		// TODO Auto-generated method stub
		return medicalSuppliesRepository.save(medicalSupplies);
	}

	@Override
	public void remove(MedicalSupplies medicalSupplies) throws Exception {
		// TODO Auto-generated method stub
		 medicalSuppliesRepository.updateRemove(medicalSupplies.getIsDelete(),medicalSupplies.getId());
	}
	
	private void createFolder(String folderName) {
		File file = new File(paramConfig.getUrlUpload()+folderName);
		file.mkdir();
	}

	@Override
	public MedicalSupplies getSupplies(String medicineName) throws Exception {
		// TODO Auto-generated method stub
		return medicalSuppliesRepository.findByMedicineName(medicineName);
	}

	@Override
	public MedicalSupplies getDetailSupplies(Integer suppliesId) throws Exception {
		// TODO Auto-generated method stub
		return medicalSuppliesRepository.findById(suppliesId).get();
	}
	
}
