package com.accenture.service;

import java.util.List;

import com.accenture.bindings.EducationDto;
import com.accenture.entity.DcChildrens;
import com.accenture.entity.DcIncome;

public interface EducationDetailService {
	
	public boolean educationDetails(EducationDto educationDto);
	
	public List<DcChildrens> getAllChildrenDetails(Integer caseNo);

}
