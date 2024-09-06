package com.like.hrm.staff.port.in.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.port.in.ResponseStaff;
import com.like.hrm.staff.port.in.StaffSelectUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

@Service
public class StaffSelectService implements StaffSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public ResponseStaff select(String companyCode, String staffNo) {
		return ResponseStaff.toDTO(this.dbPort.select(companyCode, staffNo).orElse(null));
	}
	
}
