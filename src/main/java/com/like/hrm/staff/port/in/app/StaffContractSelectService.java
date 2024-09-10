package com.like.hrm.staff.port.in.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.StaffContactSaveDTO;
import com.like.hrm.staff.port.in.StaffContractSelectUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

@Service
public class StaffContractSelectService implements StaffContractSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffContractSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public StaffContactSaveDTO select(String companyCode, String staffNo) {
		Staff staff = dbPort.select(companyCode, staffNo).orElse(null);
		
		return StaffContactSaveDTO.toDTO(staff);
	}
}
