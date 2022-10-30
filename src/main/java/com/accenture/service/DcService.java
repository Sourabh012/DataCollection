package com.accenture.service;

import java.util.List;
import java.util.Map;

import com.accenture.bindings.ChildRequest;
import com.accenture.bindings.ChildrenDto;
import com.accenture.bindings.CitizenApp;
import com.accenture.bindings.DcSummary;
import com.accenture.bindings.EducationDto;
import com.accenture.bindings.IncomeDetailsDto;
import com.accenture.bindings.PlanSelection;

public interface DcService {
	
	public Long loadCaseNo(Integer aapId);
	
	public Map<Integer,String> getPlanNames();
	
	public Long savePlanSelection(PlanSelection planSelection);
	
	public Long saveIncomeData(IncomeDetailsDto income);
	
	public Long saveEducation(EducationDto education);
	
	public Long saveChildren(ChildRequest request);
	
	public DcSummary getSummary(Long caseNo);

}
