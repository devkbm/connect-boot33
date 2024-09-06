package com.like.hrm.staff.port.in.family;

public interface StaffFamilySelectUseCase {	
	StaffFamilySaveDTO select(String companyCode, String staffNo, Long seq);
}

