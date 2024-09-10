package com.like.hrm.staff.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.jpa.StaffJpaRepository;
import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.StaffId;
import com.like.hrm.staff.domain.appointment.AppointmentRecord;
import com.like.hrm.staff.port.out.StaffAppointmentSelectDbPort;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class StaffAppointmentSelectDbAdapter implements StaffAppointmentSelectDbPort {
	
	StaffJpaRepository repository;
	
	StaffAppointmentSelectDbAdapter(StaffJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public AppointmentRecord select(String companyCode, String staffNo, Long seq) {
		Staff staff = repository.findById(new StaffId(companyCode, staffNo))
				 				.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원번호가 존재하지 않습니다."));
				
		return staff.getAppointmentRecordList().get(staff, seq);			
	}	

}
