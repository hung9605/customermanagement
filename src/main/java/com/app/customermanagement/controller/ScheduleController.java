package com.app.customermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.customermanagement.dto.model.ScheduleDto;
import com.app.customermanagement.dto.response.ResponseBean;
import com.app.customermanagement.model.Customer;
import com.app.customermanagement.service.serviceimpl.ScheduleServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/schedulemedical")
@CrossOrigin("*")
public class ScheduleController extends BaseController {
	
	private final ScheduleServiceImpl serviceImpl;
	
	@GetMapping("/listday")
	public ResponseEntity<?> listday(@RequestParam(defaultValue = "0") int page,
			@RequestParam String date){
		return response(new ResponseBean(serviceImpl.getListByDay(date)));
	}
	
	@GetMapping("/listname")
	public ResponseEntity<?> listname(@RequestParam(defaultValue = "0") int page,
			@RequestParam String name
			,@RequestParam String date){
		return response(new ResponseBean(serviceImpl.getListByName(name, date)));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ScheduleDto sMedical) throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.register(sMedical)));
		}catch (Exception e) {
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

	@PostMapping("/addexistscustomer")
	public ResponseEntity<?> addExistsCustomer(@RequestBody ScheduleDto sMedical) throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.registerExistsCustomer(sMedical)));
		}catch (Exception e) {
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody ScheduleDto sMedical) throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.updateScheduleMedical(sMedical)));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@GetMapping("/listregister")
	public ResponseEntity<?> listRegister() throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.getListRegister()));
		}catch (Exception e) {
			return responseError(new ResponseBean(e.getMessage()), e);
		}
	}
	
	@GetMapping("/listhistory")
	public ResponseEntity<?> listHistory(
			 @RequestParam(defaultValue = "0") int page
			,@RequestParam(defaultValue = "0") String date
			,@RequestParam(defaultValue = "0", required = false) String toDate
			){
		return response(new ResponseBean(serviceImpl.getListHistory(date,toDate)));
	}

	@GetMapping("/listhistoryexport")
	public ResponseEntity<?> listHistoryexport(
			@RequestParam(defaultValue = "0") int page
			,@RequestParam(defaultValue = "0") String date
			,@RequestParam(defaultValue = "0", required = false) String toDate
	){
		return response(new ResponseBean(serviceImpl.getListHistoryExport(date,toDate)));
	}
	
	@GetMapping("/checktime")
	public ResponseEntity<?> checkTime(@RequestParam(defaultValue = "0") String time) throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.checkTimeRegister(time)));
		}catch (Exception e) {
			return responseError(new ResponseBean(e), e);
		}
	}
	
	@PostMapping("/listhistory")
	public ResponseEntity<?> listhistory(@RequestBody Customer customer){
		return response(new ResponseBean(serviceImpl.getListMedicalHistory(customer)));
	}

	@GetMapping("/listhistoryall")
	public ResponseEntity<?> listHistoryAll(
			 @RequestParam(defaultValue = "0") int page
			,@RequestParam(defaultValue = "0") String date
			,@RequestParam(defaultValue = "0", required = false) String toDate
			){
		return response(new ResponseBean(serviceImpl.getListRegisterAll(date,toDate)));
	}

	
}
