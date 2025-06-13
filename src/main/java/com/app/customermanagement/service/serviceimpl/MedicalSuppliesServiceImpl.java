package com.app.customermanagement.service.serviceimpl;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.repository.InventoryRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.SuppliesDetail;
import com.app.customermanagement.dto.model.SuppliesListDto;
import com.app.customermanagement.mapper.SuppliesMapper;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.repository.MedicalSuppliesRepository;
import com.app.customermanagement.service.MedicalSupplyService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MedicalSuppliesServiceImpl implements MedicalSupplyService {
	
	private final MedicalSuppliesRepository medicalSuppliesRepository;
	private final ParamConfig paramConfig;
	private final EntityManager entityManager;
	private final SuppliesMapper mapper;
	private final InventoryRepository inventoryRepository;

	@Override
	public MedicalSupplies add(MedicalSupplies medicalSupplies) throws Exception {
		// TODO Auto-generated method stub
		medicalSupplies.setId(null);
		medicalSupplies.setCreatedAt(new Date());
		medicalSupplies.setCreatedBy(CommonConstant.ADMIN);
		medicalSupplies.setStatus(true);
		medicalSupplies.setIsDelete(false);
		medicalSupplies =  medicalSuppliesRepository.save(medicalSupplies);
		if(medicalSupplies.getIsInventory()){
			Inventory inventory = new Inventory();
			inventory.setId(null);
			inventory.setQuantity(Integer.parseInt(medicalSupplies.getQuantity()));
			inventory.setStatus("in_stock");
			inventory.setMedicalSupplies(medicalSupplies);
			inventoryRepository.save(inventory);
		}
		createFolder(String.valueOf(medicalSupplies.getId()));
		return medicalSupplies;
	}   
	
	@Cacheable(value = "medicalSuppliesCache")
	@Override
	public List<SuppliesListDto> listMedicalSupplies() throws Exception {
		// TODO Auto-generated method stub
		return mapper.mapToDtos(medicalSuppliesRepository.findByIsDeleteFalseAndQuantityGreaterThanZero());
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

	@Override
	@Transactional
	public void updateDetail(SuppliesDetail suppliesDetail) throws Exception {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<MedicalSupplies> update = criteriaBuilder.createCriteriaUpdate(MedicalSupplies.class);
		Root<MedicalSupplies> root = update.from(MedicalSupplies.class);
		if (null != suppliesDetail.getMedicineName()) {
			update.set("medicineName", suppliesDetail.getMedicineName());
		}
		if (null != suppliesDetail.getDescription()) {
			update.set("description", suppliesDetail.getDescription());
		}
		if (null != suppliesDetail.getQuantity()) {
			update.set("quantity", suppliesDetail.getQuantity());
		}
		if (null != suppliesDetail.getUnitPrice()) {
			update.set("unitPrice", suppliesDetail.getUnitPrice());
		}
		if (null != suppliesDetail.getLink()) {
			update.set("link", suppliesDetail.getLink());
		}
		update.set("updatedBy", CommonConstant.ADMIN);
		update.set("updatedAt", new Date());
		update.where(criteriaBuilder.equal(root.get("id"), suppliesDetail.getId()));
		entityManager.createQuery(update).executeUpdate();
	}

	@CacheEvict(value = "medicalSuppliesCache", allEntries = true)
	@Override
	public void clearCache() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
