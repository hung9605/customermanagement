package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.MedicalSupplies;
import com.app.customermanagement.model.Prescription;
import com.app.customermanagement.service.MedicalSupplyService;
import com.app.customermanagement.service.PrescriptionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/prescription")
@CrossOrigin("*")
public class PrescriptionController extends BaseController{
	
	private final PrescriptionService prescriptionService;
	
	@PostMapping("/list")
	public ResponseEntity<?> list(@RequestBody MedicalExamination medicalExamination) {
		try {
			return response(new ResponseBean(prescriptionService.list(medicalExamination)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

	@PostMapping("/listsupplies")
	public ResponseEntity<?> listSupplies(@RequestBody MedicalExamination medicalExamination) {
		try {
			return response(new ResponseBean(prescriptionService.getListSupplies(medicalExamination.getId())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Prescription prescription){
		try {
			return response(new ResponseBean(prescriptionService.add(prescription)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Prescription prescription){
		try {
			return response(new ResponseBean(prescriptionService.update(prescription)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

}
