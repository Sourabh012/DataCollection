package com.accenture.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DcChildrens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer childrenId;
	
	private Integer caseNo;
	
	private Integer childrenDob;
	
	private Integer childrenSsn;
	
	
}
