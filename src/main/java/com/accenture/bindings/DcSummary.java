package com.accenture.bindings;

import java.util.List;

import com.accenture.entity.DcChildrens;
import com.accenture.entity.DcEducation;
import com.accenture.entity.DcIncome;

import lombok.Data;

@Data
public class DcSummary {

	private IncomeDetailsDto income;
	
	private EducationDto education;
	
	private List<ChildrenDto> childern;
	
	private String planName;
	
}
