package com.accenture.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.DcCase;

public interface DcCaseRepo extends JpaRepository<DcCase, Serializable>{

	public DcCase findByAppId(Integer appId);
	
	
}
