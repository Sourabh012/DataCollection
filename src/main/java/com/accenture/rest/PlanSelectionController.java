package com.accenture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.accenture.bindings.PlanSelection;
import com.accenture.service.DcService;

public class PlanSelectionController {
	
	@Autowired
	private DcService service;

	@PostMapping("/plansel")
	public ResponseEntity<Long> planSelection(@RequestBody PlanSelection planSelection) {
		
		Long caseNo = service.savePlanSelection(planSelection);
		
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
		
	}
	
}
