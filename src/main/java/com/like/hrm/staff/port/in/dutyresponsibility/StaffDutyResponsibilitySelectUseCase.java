package com.like.hrm.staff.port.in.dutyresponsibility;

public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilityDTO select(String companyCode, String staffNo, Long seq);
}
