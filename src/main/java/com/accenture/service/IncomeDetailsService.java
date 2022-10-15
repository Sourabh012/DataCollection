package com.accenture.service;

import java.util.List;

import com.accenture.bindings.IncomeDetailsDto;
import com.accenture.entity.DataCases;
import com.accenture.entity.DcIncome;

public interface IncomeDetailsService {

	public boolean incomeDetails(IncomeDetailsDto incomeDetailsDto);
	
	public List<DcIncome> getAllDcIncomeDetails(Integer caseNo);
	
}
