package com.accenture.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Serializable>{

}
