package com.like.hrm.staff.port.in.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.StaffName;
import com.like.hrm.staff.domain.StaffNoCreateStrategy;
import com.like.hrm.staff.port.in.StaffCreateDTO;
import com.like.hrm.staff.port.in.StaffCreateUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityExistsException;

@Service
public class StaffCreateService implements StaffCreateUseCase {

	StaffCommandDbPort dbPort;
	
	StaffCreateService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void create(StaffCreateDTO dto) {
		if (isExistStaff(dto.companyCode(), dto.staffNo())) throw new EntityExistsException("동일 직원번호가 존재합니다 : " + dto.getStaffId());

		StaffNoCreateStrategy strategy = () -> dto.staffNo();
		
		Staff staff = new Staff(dto.companyCode()
				               ,strategy
				               ,new StaffName(dto.name(), dto.nameEng(), dto.nameEng())
				               ,dto.residentRegistrationNumber());
									
		dbPort.save(staff);
	}
	
	private boolean isExistStaff(String companyCode, String staffNo) {
		return dbPort.select(companyCode, staffNo).isPresent();
	}

}
