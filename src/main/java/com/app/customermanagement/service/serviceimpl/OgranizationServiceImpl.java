package com.app.customermanagement.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.model.Ogranization;
import com.app.customermanagement.repository.OgranizationRepository;
import com.app.customermanagement.service.OgranizationService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OgranizationServiceImpl implements OgranizationService {
	
	private final OgranizationRepository ogranizationRepository;
	private final EntityManager entityManager;

	@Override
	public Ogranization save(Ogranization ogranization) throws Exception {
		return ogranizationRepository.save(ogranization);
	}

	@Override
	public List<Ogranization> findAll() throws Exception {
		return ogranizationRepository.findAll();
	}

	@Override
	public Integer update(Ogranization ogranization) throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Ogranization> update = builder.createCriteriaUpdate(Ogranization.class);
		Root<Ogranization> root = update.from(Ogranization.class);
		if(null != ogranization.getFullName()) {
			update.set("fullName", ogranization.getFullName());
		}
		if(null != ogranization.getDateOfBirth()) {
			update.set("dateOfBirth", ogranization.getDateOfBirth());
		}
		if(null != ogranization.getImage()) {
			update.set("image",ogranization.getImage());
		}
		if(null != ogranization.getParentId()) {
			update.set("orderNumber", ogranization.getParentId());
		}
		if(null != ogranization.getRole()) {
			update.set("role", ogranization.getRole());
		}
		if(null != ogranization.getStyleClass()) {
			update.set("styleClass", ogranization.getStyleClass());
		}
		update.set("updatedBy", CommonConstant.ADMIN);
		update.set("updatedAt", new Date());
		update.where(builder.equal(root.get("id"),ogranization.getId()));
		return entityManager.createQuery(update).executeUpdate();
	
	}

	@Override
	public void delete(Ogranization ogranization) throws Exception {
		ogranizationRepository.deleteById(ogranization.getId());
		
	}

}
