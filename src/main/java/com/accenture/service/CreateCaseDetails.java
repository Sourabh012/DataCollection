package com.accenture.service;

import java.util.List;

import com.accenture.bindings.NewCaseEntryDto;
import com.accenture.entity.DataCases;
import com.accenture.entity.DcChildrens;

public interface CreateCaseDetails {
	
	public boolean createCaseNo(NewCaseEntryDto newCaseEntryDto);
	
	public List<DataCases> getAllDataCasesDetails();

}
