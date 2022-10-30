package com.accenture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class DcCase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long caseNO;
	
	private Integer appId;
	
	private Integer planId;
	
	
	
}
