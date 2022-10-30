package com.accenture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bindings.EducationDto;
import com.accenture.service.DcService;

@RestController
public class EducationController {

	@Autowired
	private DcService service;
	
	@PostMapping("/education")
	public ResponseEntity<Long> saveEducation(@RequestBody EducationDto education){
		Long caseNo = service.saveEducation(education);
		return new ResponseEntity<>(caseNo,HttpStatus.CREATED);
	}
}
