package com.like.hrm.staff.application.port.in.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.dto.ResponseStaffDutyResponsibility;

public interface StaffDutyResponsibilityQueryUseCase {

	List<ResponseStaffDutyResponsibility> select(String companyCode, String staffNo);
}
