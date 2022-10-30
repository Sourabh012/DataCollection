package com.accenture.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.bindings.ChildRequest;
import com.accenture.bindings.ChildrenDto;
import com.accenture.bindings.CitizenApp;
import com.accenture.bindings.DcSummary;
import com.accenture.bindings.EducationDto;
import com.accenture.bindings.IncomeDetailsDto;
import com.accenture.bindings.PlanSelection;
import com.accenture.entity.CitizenAppEntity;
import com.accenture.entity.DcCase;
import com.accenture.entity.DcChildrens;
import com.accenture.entity.DcEducation;
import com.accenture.entity.DcIncome;
import com.accenture.entity.PlanEntity;
import com.accenture.repository.CitizenAppRepository;
import com.accenture.repository.DcCaseRepo;
import com.accenture.repository.DcChildrenRepo;
import com.accenture.repository.DcEducationRepo;
import com.accenture.repository.DcIncomeRepo;
import com.accenture.repository.PlanRepo;


@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private DcCaseRepo dcCaseRepo;
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private DcIncomeRepo incomeRepo;
	
	@Autowired
	private DcEducationRepo educationRepo;
	
	@Autowired
	private DcChildrenRepo childRepo;
	
	@Autowired
	private CitizenAppRepository appRepo;
	
	
	@Override
	public Long loadCaseNo(Integer aapId) {
		Optional<CitizenAppEntity> app = appRepo.findById(aapId);
		
		if(app.isPresent()) {
			DcCase entity = new DcCase();
			entity.setAppId(aapId);
			
			entity = dcCaseRepo.save(entity);
			
			return entity.getCaseNO();
		}
		
		return null;
	}

	@Override
	public Map<Integer,String> getPlanNames() {
		
		List<PlanEntity> findAll = planRepo.findAll();
		
		Map<Integer, String> planMap = new HashMap<>();
		
		for(PlanEntity entity : findAll)
		{
			planMap.put(entity.getPlanId(),entity.getPlanName());
		}
		return planMap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
		
		Optional<DcCase> findById = dcCaseRepo.findById(planSelection.getCaseNO());
		if(findById.isPresent())
		{
			DcCase dcCase = findById.get();
			dcCase.setPlanId(planSelection.getPlanId());
			
			dcCaseRepo.save(dcCase);
			return planSelection.getCaseNO();
			
		}
		
		return null;
	}

	@Override
	public Long saveIncomeData(IncomeDetailsDto income) {
		DcIncome entity = new DcIncome();
		BeanUtils.copyProperties(income, entity);
		incomeRepo.save(entity);
		
		return income.getCaseNo();
	}

	@Override
	public Long saveEducation(EducationDto education) {
		DcEducation entity = new DcEducation();
		BeanUtils.copyProperties(education, entity);
		educationRepo.save(entity);
		
		return education.getCaseNo();
	}

	@Override
	public Long saveChildren(ChildRequest request) {
		List<ChildrenDto> childs = request.getChilds();
		for(ChildrenDto c : childs)
		{
			DcChildrens entity = new DcChildrens();
			BeanUtils.copyProperties(c, entity);
			childRepo.save(entity);
		}
		
		return request.getCaseNo();
	}

	@Override
	public DcSummary getSummary(Long caseNo) {
		
		String planName="";
		
		DcIncome incomeEntity = incomeRepo.findByCaseNo(caseNo);
		DcEducation educationEntity = educationRepo.findByCaseNo(caseNo);
		List<DcChildrens> childsEntity = childRepo.findByCaseNo(caseNo);
		Optional<DcCase> dcCase = dcCaseRepo.findById(caseNo);
		if(dcCase.isPresent())
		{
			Integer planId = dcCase.get().getPlanId();
			Optional<PlanEntity> plan = planRepo.findById(planId);
			if(plan.isPresent()) {
			   planName = plan.get().getPlanName();
			}
		}
		
		//set the data to summary obj
		
		DcSummary summary = new DcSummary();
		summary.setPlanName(planName);
		
		IncomeDetailsDto income= new IncomeDetailsDto();
		BeanUtils.copyProperties(incomeEntity,income );
		summary.setIncome(income);
		
		EducationDto education = new EducationDto();
		BeanUtils.copyProperties(educationEntity,education);
		summary.setEducation(education);
		
		List<ChildrenDto> childs = new ArrayList<>();
		for(DcChildrens entity : childsEntity) {
			ChildrenDto ch = new ChildrenDto();
			BeanUtils.copyProperties(entity, ch);
			childs.add(ch);
		}
		summary.setChildern(childs);
		
		return summary;
	}

}
