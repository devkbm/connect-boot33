package com.like.hrm.staff.port.in.dutyresponsibility;

import java.util.List;

import com.like.hrm.staff.port.in.ResponseStaffDutyResponsibility;

public interface StaffDutyResponsibilityQueryUseCase {

	List<ResponseStaffDutyResponsibility> select(String companyCode, String staffNo);
}
