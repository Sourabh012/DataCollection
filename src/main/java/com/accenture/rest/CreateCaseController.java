package com.accenture.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bindings.CreateCaseResponse;
import com.accenture.service.DcService;


@RestController
public class CreateCaseController {

	@Autowired
	private DcService service;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId) {
		
		Long caseNo = service.loadCaseNo(appId);
		
		 Map<Integer, String> planNames = service.getPlanNames();
		 
		 CreateCaseResponse response = new CreateCaseResponse();
		 response.setCaseNo(caseNo);
		 response.setPlanNames(planNames);
		 
		 return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
