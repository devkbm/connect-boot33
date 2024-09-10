package com.like.hrm.staff.port.in.app;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.StaffImageUploadUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffImageUploadService implements StaffImageUploadUseCase {
	
	StaffCommandDbPort dbPort;	
	
	StaffImageUploadService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;	
	}	

	@Override
	public String saveUploadImagePath(String companyCode, String staffNo, File file) throws IOException {
		Staff entity = this.dbPort.select(companyCode, staffNo)
				  .orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));;

		if (entity == null) return null;

		String path = file.getCanonicalPath();
		
		entity.changeImagePath(path);

		this.dbPort.save(entity);
		
		return path;
	}

}
