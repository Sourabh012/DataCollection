package com.accenture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DcIncome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	
	private Integer caseNo;
	
	private Integer empIncome;
	
	private Integer rentIncome;
	
	private Integer propertyIncome;
	
}
