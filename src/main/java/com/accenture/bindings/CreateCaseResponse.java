package com.accenture.bindings;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponse {

	private Long caseNo;
	
	private Map<Integer, String> planNames;
}
