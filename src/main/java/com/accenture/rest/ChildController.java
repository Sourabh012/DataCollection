package com.accenture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bindings.ChildRequest;
import com.accenture.bindings.DcSummary;
import com.accenture.service.DcService;

@RestController
public class ChildController {

	
	@Autowired
	private DcService service;
	
	@PostMapping("/childrens")
	public ResponseEntity<DcSummary> saveChilds(@RequestBody ChildRequest request){
		Long caseNo = service.saveChildren(request);
		
		DcSummary summary =  service.getSummary(caseNo);
		
		return new ResponseEntity<>(summary,HttpStatus.OK);
	}
}
