package com.accenture.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.DcChildrens;
import com.accenture.entity.DcIncome;

public interface DcChildrenRepo extends JpaRepository<DcChildrens, Serializable>{

	public List<DcChildrens> findByCaseNo(Long caseNo); 
}
