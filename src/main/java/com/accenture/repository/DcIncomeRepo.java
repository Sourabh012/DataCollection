package com.accenture.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.DcIncome;

public interface DcIncomeRepo extends JpaRepository<DcIncome, Serializable>{

	public DcIncome findByCaseNo(Long caseNo);
}
