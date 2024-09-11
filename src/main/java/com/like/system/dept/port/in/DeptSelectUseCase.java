package com.like.system.dept.port.in;

import com.like.system.dept.port.in.dto.DeptSaveDTO;

public interface DeptSelectUseCase {
	DeptSaveDTO select(String companyCode, String deptCode);	
}
