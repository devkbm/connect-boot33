package com.like.system.dept.port.in;

public interface DeptSelectUseCase {
	DeptSaveDTO select(String companyCode, String deptCode);	
}
