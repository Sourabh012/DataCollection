package com.accenture.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.DcEducation;
import com.accenture.entity.DcIncome;

public interface DcEducationRepo extends JpaRepository<DcEducation, Serializable>{

	public DcEducation findByCaseNo(Long caseNo);
}
