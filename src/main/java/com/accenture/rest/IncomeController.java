package com.accenture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bindings.IncomeDetailsDto;
import com.accenture.service.DcService;

@RestController
public class IncomeController {

	@Autowired
	private DcService service;
	
	
	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody IncomeDetailsDto income){
		Long caseNo = service.saveIncomeData(income);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
	
}
