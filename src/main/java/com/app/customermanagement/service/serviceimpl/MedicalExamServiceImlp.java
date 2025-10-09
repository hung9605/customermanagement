package com.app.customermanagement.service.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.constants.CommonConstant;
import com.app.customermanagement.dto.model.MoneyDetail;
import com.app.customermanagement.dto.model.MoneyDto;
import com.app.customermanagement.dto.model.PrescriptionDto;
import com.app.customermanagement.dto.response.MoneyChartDto;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.model.Prescription;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.repository.InventoryRepository;
import com.app.customermanagement.repository.MedicalExaminationRepository;
import com.app.customermanagement.repository.MedicalSuppliesRepository;
import com.app.customermanagement.repository.PrescriptionRepository;
import com.app.customermanagement.repository.ScheduleMedicalRepository;
import com.app.customermanagement.service.KafkaService;
import com.app.customermanagement.service.MedicalExamService;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicalExamServiceImlp implements MedicalExamService {

    private final InventoryRepository inventoryRepository;
	
	private final MedicalExaminationRepository medicalExaminationRepository;
	private final ScheduleMedicalRepository scheduleMedicalRepository;
	private final PrescriptionRepository prescriptionRepository;
	private final MedicalSuppliesRepository medicalSuppliesRepository;
	private final EntityManager entityManager;
	private final KafkaService kafkaService;
	private final ParamConfig paramConfig;



	/**
	 * @param medicalExamination
	 * @return
	 */
    @Override
    @Transactional
    public MedicalExamination addMedicalExamination(MedicalExamination medicalExamination) throws Exception{
    	List<MedicalSupplies> medicalSupplies = medicalSuppliesRepository.findByIsDeleteFalseAndQuantityGreaterThanZero();
    	ScheduleMedical scheduleMedical = scheduleMedicalRepository.findById(medicalExamination.getMedical().getId())
    	.orElseThrow(() -> new RuntimeException("Schedule not found"));
    	medicalExamination.setMedical(scheduleMedical);
    	medicalExamination.setId(null);
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	List<Prescription> lstPrescription = new ArrayList<>();
    	String[] typeMedicine = medicalExamination.getTypeOfMedicine().split(",");
    	String[] quantity = medicalExamination.getQuantity().split(",");
    	Prescription prescription;
    	for (int i = 0; i < quantity.length; i++) {
    		String typeMedicineVal = typeMedicine[i];
    		MedicalSupplies supplies =  medicalSupplies.stream().filter(item -> item.getMedicineName().equals(typeMedicineVal))
    				.findFirst().orElseThrow(() -> new RuntimeException("Medical supply not found: " + typeMedicineVal));
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
    	lstPrescription = prescriptionRepository.saveAll(lstPrescription);
    	 if(paramConfig.getIsKafka() == 1) {
			 System.out.println("Send to kafka ... ");
			 sendKafka(lstPrescription);
		 }else {
			 insertInventoryWhenKafkaNotStart(lstPrescription,mExamination.getId());
		 }
    	
        return mExamination;
    }
    
   
    private void sendKafka(List<Prescription> prescriptions) {
    	prescriptions.stream().forEach(prescription -> {
    		        PrescriptionDto dto = new PrescriptionDto();
    		        dto.setId(prescription.getId());
    		        dto.setMedicineName(prescription.getMedicalSupplies().getMedicineName());
    		        dto.setIdSupplies(prescription.getMedicalSupplies().getId());
    		        dto.setIdExam(prescription.getMedicalExamination().getId());
    		        dto.setQuantity(String.valueOf(prescription.getQuantity()));
    		        dto.setUnitPrice(String.valueOf(prescription.getMedicalSupplies().getUnitPrice()));
    		        
    		        CompletableFuture<SendResult<String, Object>> future = 
    		        		kafkaService.sendMessage(CommonConstant.TOPPIC_SUPPLIES, dto);
    		        future.whenComplete((result,e) -> {
    					if(e != null) {
    						System.out.println("error send kafka" + e);
    						executeWhenKafkaError(prescription);
    					}else {
    						System.out.println("Send ok");
    					}
    				});
    		    });

    }

	private void executeWhenKafkaError(Prescription prescription) {
		Inventory inventory = convertToInventory(prescription,CommonConstant.STOCK_STATUS_OUT);
		inventoryRepository.save(inventory);
	}
	
	private void insertInventoryWhenKafkaNotStart(List<Prescription> prescriptions,Integer idExam) {
		List<Inventory> listInventories = new ArrayList<>();
		prescriptions.stream().forEach(item -> {
			Inventory inventory = convertToInventory(item,CommonConstant.STOCK_STATUS_OUT);
			inventory.setDescription(String.valueOf(idExam));
			listInventories.add(inventory);
		});
		
		inventoryRepository.saveAll(listInventories);
	}
	
	private Inventory convertToInventory(Prescription prescription,String status) {
	    Inventory inventory = new Inventory();
	    inventory.setId(null);
	    inventory.setQuantity(Integer.parseInt(prescription.getQuantity()));
	    inventory.setStatus(status);
	    inventory.setReceivedDate(LocalDateTime.now());
	    inventory.setMedicalSupplies(prescription.getMedicalSupplies());
	    return inventory;
	}


	/**
	 *
	 * @param medicalExamination
	 * @return
	 */
	@Override
    public MedicalExamination updateMedicalExamination(MedicalExamination medicalExamination) {
    	//prescriptionRepository.deletePrescription(medicalExamination);
		List<MedicalSupplies> medicalSupplies = medicalSuppliesRepository.findAll();
    	MedicalExamination mExamination = medicalExaminationRepository.save(medicalExamination);
    	List<Prescription> lstPrescription = new ArrayList<>();
    	//get old prescription 
    	List<Prescription> lstPresOld = prescriptionRepository.findByMedicalExamination(medicalExamination);
    	Map<String, Prescription> oldMap = lstPresOld.stream().collect(Collectors.toMap(p -> p.getMedicalSupplies().getMedicineName(), p -> p));
    	
    	String[] typeMedicine = medicalExamination.getTypeOfMedicine().split(",");
    	String[] quantity = medicalExamination.getQuantity().split(",");
    	Set<String> newMedicineSet = new HashSet<>(Arrays.asList(typeMedicine)); 
    	Prescription prescription;
    	for (int i = 0; i < quantity.length; i++) {
    			String typeMedicineVal = typeMedicine[i];
    			MedicalSupplies supplies =  medicalSupplies.stream().filter(
    				item -> item.getMedicineName().equals(typeMedicineVal)).findFirst()
    				.orElseThrow(() -> new RuntimeException("Medical supply not found: " + typeMedicineVal));
	    		Prescription oldPrescription = oldMap.get(typeMedicineVal);
	    		if(null == oldPrescription) {
				prescription = new Prescription(null, quantity[i], supplies, mExamination);
				prescription.setCreatedAt(new Date());
				prescription.setCreatedBy(CommonConstant.ADMIN);
				lstPrescription.add(prescription);
    		}else {
    			oldPrescription.setQuantity(quantity[i]);
    			lstPrescription.add(oldPrescription);
    		}
		}
    	
    	List<Prescription> toDelete = lstPresOld.stream()
    	        .filter(p -> !newMedicineSet.contains(p.getMedicalSupplies().getMedicineName()))
    	        .collect(Collectors.toList());
    	prescriptionRepository.deleteAll(toDelete);
    	lstPrescription = prescriptionRepository.saveAll(lstPrescription);
    	if(paramConfig.getIsKafka() == 1) {
    		sendKafka(lstPrescription);
    	}else {
    		insertInventoryWhenKafkaNotStart(lstPrescription,mExamination.getId());
    	}
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


	@Override
	public List<MoneyChartDto> getDataChart(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return medicalExaminationRepository.getDataChartMoney(fromDate, toDate);
	}


	



}