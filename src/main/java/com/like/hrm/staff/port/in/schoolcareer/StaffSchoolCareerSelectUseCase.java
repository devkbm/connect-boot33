package com.like.hrm.staff.port.in.schoolcareer;

public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerSaveDTO select(String companyCode, String staffNo, Long seq);
}
