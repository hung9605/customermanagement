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
import com.app.customermanagement.model.ScheduleMedical;
import com.app.customermanagement.service.serviceimpl.ScheduleServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/schedulemedical")
@CrossOrigin("*")
public class ScheduleController extends BaseController {
	
	private final ScheduleServiceImpl serviceImpl;
	
	@GetMapping("/listday")
	public ResponseEntity<?> listday(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "date") String date){
		return response(new ResponseBean(serviceImpl.getListByDay(date)));
	}
	
	@GetMapping("/listname")
	public ResponseEntity<?> listname(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "name") String name
			,@RequestParam(name = "date") String date){
		return response(new ResponseBean(serviceImpl.getListByName(name, date)));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ScheduleDto sMedical) throws Exception{
		return response(new ResponseBean(serviceImpl.register(sMedical)));
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody ScheduleDto sMedical) throws Exception{
		return response(new ResponseBean(serviceImpl.register(sMedical)));
	}
	
	@GetMapping("/listregister")
	public ResponseEntity<?> listRegister() throws Exception{
		try {
			return response(new ResponseBean(serviceImpl.getListRegister()));
		}catch (Exception e) {
			return responseError(new ResponseBean(e), e);
		}
	}
	
	@GetMapping("/listhistory")
	public ResponseEntity<?> listHistory(
			 @RequestParam(name = "page", defaultValue = "0") int page
			,@RequestParam(name = "date", defaultValue = "0") String date
			){
		return response(new ResponseBean(serviceImpl.getListHistory(date)));
	}
	
//	@PostMapping("/addv1")
//	public ResponseEntity<?> addV1(@RequestBody ScheduleMedical sMedical){
//		return response(new ResponseBean(serviceImpl.register(sMedical)));
//	}
	
}
