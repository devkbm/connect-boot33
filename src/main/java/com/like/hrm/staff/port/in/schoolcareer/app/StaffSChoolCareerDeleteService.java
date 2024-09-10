package com.like.hrm.staff.port.in.schoolcareer.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.schoolcareer.StaffSchoolCareerDeleteUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffSChoolCareerDeleteService implements StaffSchoolCareerDeleteUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSChoolCareerDeleteService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String staffNo, Long seq) {
		Staff staff = dbPort.select(companyCode, staffNo)
							.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		staff.getSchoolCareerList().remove(staff, seq);
		
		this.dbPort.save(staff);
	}

}
