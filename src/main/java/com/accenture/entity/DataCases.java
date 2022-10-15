package com.accenture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class DataCases {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseId;
	
	private Integer caseNO;
	
	private Integer appId;
	
	private Integer planId;
	
	
	
}
