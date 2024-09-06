package com.like.hrm.staff.port.in.family;

import java.util.List;

public interface StaffFamilyQueryUseCase {
	List<StaffFamilySaveDTO> select(String companyCode, String staffNo);
}
