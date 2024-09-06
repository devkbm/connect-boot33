package com.like.hrm.staff.port.in;

public interface StaffSelectUseCase {
	ResponseStaff select(String companyCode, String staffNo);
}
