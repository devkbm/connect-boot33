package com.like.hrm.staff.port.in.license;

public interface StaffLicenseDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
