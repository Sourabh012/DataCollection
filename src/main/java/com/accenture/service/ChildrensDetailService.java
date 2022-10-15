package com.accenture.service;

import java.util.List;

import com.accenture.bindings.ChildrenDto;
import com.accenture.entity.DcChildrens;

public interface ChildrensDetailService {
	
	public boolean childrenDetails(List<ChildrenDto> childrenDto);
	
	public List<DcChildrens> getAllChildrenDetails(Integer caseNo);

}
