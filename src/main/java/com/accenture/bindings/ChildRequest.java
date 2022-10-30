package com.accenture.bindings;

import java.util.List;

import lombok.Data;

@Data
public class ChildRequest {
	
	private Long caseNo;
	
	private List<ChildrenDto> childs;

}
