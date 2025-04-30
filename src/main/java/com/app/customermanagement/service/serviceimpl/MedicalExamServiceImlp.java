package com.app.customermanagement.service.serviceimpl;

import com.app.customermanagement.constants.CommonConstant;
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
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalExamServiceImlp implements MedicalExamService {
	
	private final MedicalExaminationRepository medicalExaminationRepository;
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final PrescriptionRepository prescriptionRepository;
	private final MedicalSuppliesRepository medicalSuppliesRepository;

	/**
	 * @param medicalExamination
	 * @return
	 */
    @Override
    public MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) {
    	//medicalExamination.setCreatedAt(new Date());
        //medicalExamination.setCreatedBy(CommonConstant.ADMIN);
    	List<MedicalSupplies> medicalSupplies = medicalSuppliesRepository.findByIsDeleteFalseAndQuantityGreaterThanZero();
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	List<Prescription> lstPrescription = new ArrayList<>();
    	String[] typeMedicine = medicalExamination.getTypeOfMedicine().split(",");
    	String[] quantity = medicalExamination.getQuantity().split(",");
    	Prescription prescription;
    	List<MedicalSupplies> lMedicalSupplies = new ArrayList<>();
    	for (int i = 0; i < quantity.length; i++) {
    		String typeMedicineVal = typeMedicine[i];
    		MedicalSupplies supplies =  medicalSupplies.stream().filter(item -> item.getMedicineName().equals(typeMedicineVal)).findFirst().get();
			prescription = new Prescription(0, quantity[i], supplies, mExamination);
			prescription.setCreatedAt(new Date());
			prescription.setCreatedBy(CommonConstant.ADMIN);
			lstPrescription.add(prescription);
			supplies.setQuantity(String.valueOf(Integer.parseInt(supplies.getQuantity()) - Integer.parseInt(prescription.getQuantity())));
			supplies.setUpdatedAt(new Date());
			supplies.setUpdatedBy(CommonConstant.ADMIN);
			lMedicalSupplies.add(supplies);
		}
    	
    	ScheduleMedical scheduleMedical = scheduleMedicalRepository.findById(mExamination.getMedical().getId()).get();
    	scheduleMedical.setStatus(CommonConstant.EXAMINED);
    	scheduleMedicalRepository.save(scheduleMedical);
    	prescriptionRepository.saveAll(lstPrescription);
    	medicalSuppliesRepository.saveAll(lMedicalSupplies);
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
    	//medicalExamination.setUpdatedAt(new Date());
		//medicalExamination.setUpdatedBy(CommonConstant.ADMIN);
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
	@Override
	public List<MoneyDto> listMoney(Integer page, String date, String toDate) {
		return medicalExaminationRepository.listMoney(date,toDate);
	}

	/**
	 * @param lstSupplies
	 * @param prescription
	 */
	private void updateMedicalSupplies(List<MedicalSupplies> lstSupplies,Prescription prescription) {
		MedicalSupplies medicalSupplies =  lstSupplies.stream().filter(item -> item.getId().equals(prescription.getMedicalSupplies().getId())).findFirst().get();
	}

}