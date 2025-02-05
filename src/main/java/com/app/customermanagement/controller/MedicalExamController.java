package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.MedicalExamination;
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.service.MedicalExamService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalexam")
@CrossOrigin("*")
public class MedicalExamController extends BaseController{
	
	private final MedicalExamService medicalExamService;
	
	public ResponseEntity<?> list(){
		return response(null);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody MedicalExamination medicalExamination){
		return response(new ResponseBean(medicalExamService.addMedicalExamination(medicalExamination)));
	}
	
	@GetMapping("getbyidschedule")
	public ResponseEntity<?> getByIdSchedule(@RequestParam(name="id") int idSchedule){
		return response(new ResponseBean(medicalExamService.getByIdSchedule(new ScheduleMedical(idSchedule))));
	}

	@GetMapping("/list")
	public ResponseEntity<?> listMoney(
			@RequestParam(defaultValue = "0") int page
			,@RequestParam(defaultValue = "0") String date
			,@RequestParam(defaultValue = "0") String toDate
	){
		return response(new ResponseBean(medicalExamService.listMoney(0,date,toDate)));
	}
	
}
