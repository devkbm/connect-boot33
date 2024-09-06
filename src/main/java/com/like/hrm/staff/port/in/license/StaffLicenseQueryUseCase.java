package com.like.hrm.staff.port.in.license;

import java.util.List;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseSaveDTO> select(String companyCode, String staffNo);
}
