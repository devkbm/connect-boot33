package com.like.hrm.staff.port.in.schoolcareer;

import java.util.List;

public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerSaveDTO> select(String companyCode, String staffNo);
}
