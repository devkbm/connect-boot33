package com.like.hrm.staff.port.in.dutyresponsibility.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.StaffQueryRepository;
import com.like.hrm.staff.port.in.ResponseStaffDutyResponsibility;
import com.like.hrm.staff.port.in.dutyresponsibility.StaffDutyResponsibilityQueryUseCase;

@Transactional(readOnly = true)
@Service
public class StaffDutyResponsibilityQueryService implements StaffDutyResponsibilityQueryUseCase {

	StaffQueryRepository dbPort;
	
	StaffDutyResponsibilityQueryService(StaffQueryRepository dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<ResponseStaffDutyResponsibility> select(String companyCode, String staffNo) {
		return this.dbPort.getStaffDutyResponsibility(companyCode, staffNo);
	}
}
