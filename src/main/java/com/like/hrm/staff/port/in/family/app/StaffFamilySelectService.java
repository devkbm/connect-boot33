package com.like.hrm.staff.port.in.family.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.family.StaffFamilySaveDTO;
import com.like.hrm.staff.port.in.family.StaffFamilySelectUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffFamilySelectService implements StaffFamilySelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffFamilySelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public StaffFamilySaveDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = dbPort.select(companyCode, staffNo)
							.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		return StaffFamilySaveDTO.toDTO(staff.getFamilyList().get(staff, seq));
	}
}
