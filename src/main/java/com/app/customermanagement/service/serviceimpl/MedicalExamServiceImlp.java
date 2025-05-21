package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.MoneyDetail;
import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.model.Prescription;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.MedicalExaminationRepository;
import com.app.customermanagement.repository.MedicalSuppliesRepository;
import com.app.customermanagement.repository.PrescriptionRepository;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.MedicalExamService;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalExamServiceImlp implements MedicalExamService {
	
	private final MedicalExaminationRepository medicalExaminationRepository;
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final PrescriptionRepository prescriptionRepository;
	private final MedicalSuppliesRepository medicalSuppliesRepository;
	private final EntityManager entityManager;

	/**
	 * @param medicalExamination
	 * @return
	 */
    @Override
    public MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) {
    	List<MedicalSupplies> medicalSupplies = medicalSuppliesRepository.findByIsDeleteFalseAndQuantityGreaterThanZero();
    	ScheduleMedical scheduleMedical = scheduleMedicalRepository.findById(medicalExamination.getMedical().getId())
    	.orElseThrow(() -> new RuntimeException("Schedule not found"));
    	//medicalExamination.setMedical(scheduleMedical);
    	medicalExamination.setId(null);
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	List<Prescription> lstPrescription = new ArrayList<>();
    	String[] typeMedicine = medicalExamination.getTypeOfMedicine().split(",");
    	String[] quantity = medicalExamination.getQuantity().split(",");
    	Prescription prescription;
    	for (int i = 0; i < quantity.length; i++) {
    		String typeMedicineVal = typeMedicine[i];
    		MedicalSupplies supplies =  medicalSupplies.stream().filter(item -> item.getMedicineName().equals(typeMedicineVal)).findFirst().get();
    		entityManager.detach(supplies);
			prescription = new Prescription(null, quantity[i], supplies, mExamination);
			prescription.setCreatedAt(new Date());
			prescription.setCreatedBy(CommonConstant.ADMIN);
			lstPrescription.add(prescription);
			supplies.setQuantity(String.valueOf(Integer.parseInt(supplies.getQuantity()) - Integer.parseInt(prescription.getQuantity())));
			medicalSuppliesRepository.updateQuantity(Integer.parseInt(supplies.getQuantity()), supplies.getId());
		}
    	
    	
    	scheduleMedical.setStatus(CommonConstant.EXAMINED);
    	scheduleMedicalRepository.save(scheduleMedical);
    	prescriptionRepository.saveAll(lstPrescription);
        return mExamination;
    }

	/**
	 *
	 * @param medicalExamination
	 * @return
	 */
	@Override
    public MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination) {
    	prescriptionRepository.deletePrescription(medicalExamination);
		List<MedicalSupplies> medicalSupplies = medicalSuppliesRepository.findAll();
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	List<Prescription> lstPrescription = new ArrayList<>();
    	String[] typeMedicine = medicalExamination.getTypeOfMedicine().split(",");
    	String[] quantity = medicalExamination.getQuantity().split(",");
    	Prescription prescription;
    	for (int i = 0; i < quantity.length; i++) {
    		String typeMedicineVal = typeMedicine[i];
    		MedicalSupplies supplies =  medicalSupplies.stream().filter(item -> item.getMedicineName().equals(typeMedicineVal)).findFirst().get();
			prescription = new Prescription(0, quantity[i], supplies, mExamination);
			prescription.setCreatedAt(new Date());
			prescription.setCreatedBy(CommonConstant.ADMIN);
			lstPrescription.add(prescription);
		}
    	prescriptionRepository.saveAll(lstPrescription);
        return mExamination;
    }

	/**
	 *
	 * @param customer
	 * @return
	 */
	@Override
	public List<MedicalExamination> getListByCustormer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @param sMedical
	 * @return
	 */
	@Override
	public MedicalExamination getByIdSchedule(ScheduleMedical sMedical) {
		// TODO Auto-generated method stub
		return medicalExaminationRepository.findByMedical(sMedical);
	}

	/**
	 * @param page
	 * @param date
	 * @return
	 */
	@Cacheable(value = "moneyCache", key = "#date + '_' + #toDate")
	@Override
	public List<MoneyDto> listMoney(Integer page, String date, String toDate) {
		return medicalExaminationRepository.listMoney(date,toDate);
	}

	/**
	 * @param page
	 * @param date
	 * @param toDate
	 * @return
	 */
	@Cacheable(value = "moneyExportCache", key = "#date + '_' + #toDate")
	@Override
	public List<MoneyDetail> listMoneyExport(Integer page, String date, String toDate) throws  Exception{
		return medicalExaminationRepository.listMoneyExport(date,toDate);
	}

	/**
	 * @param lstSupplies
	 * @param prescription
	 */
	private void updateMedicalSupplies(List<MedicalSupplies> lstSupplies,Prescription prescription) {
		MedicalSupplies medicalSupplies =  lstSupplies.stream().filter(item -> item.getId().equals(prescription.getMedicalSupplies().getId())).findFirst().get();
	}



}