package com.like.hrm.staff.port.in.license;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseSaveDTO select(String companyCode, String staffNo, Long seq);
}
