package com.like.hrm.staff.port.in.license.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.license.StaffLicenseQueryUseCase;
import com.like.hrm.staff.port.in.license.StaffLicenseSaveDTO;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Transactional(readOnly = true)
@Service
public class StaffLicenseQueryService implements StaffLicenseQueryUseCase {

	StaffCommandDbPort dbPort;
	
	StaffLicenseQueryService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffLicenseSaveDTO> select(String companyCode, String staffNo) {
		Staff staff = this.dbPort.select(companyCode, staffNo)
								 .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		
		return staff.getLicenseList()
				 	.getStream()
				 	.map(e -> StaffLicenseSaveDTO.toDTO(e))
				 	.toList();
	}
}
