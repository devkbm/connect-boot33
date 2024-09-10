package com.like.hrm.staff.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.jpa.StaffJpaRepository;
import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.StaffId;
import com.like.hrm.staff.domain.appointment.AppointmentRecord;
import com.like.hrm.staff.port.out.StaffAppointmentQueryDbPort;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class StaffAppointmentQueryDbAdapter implements StaffAppointmentQueryDbPort {

	StaffJpaRepository repository;
	
	StaffAppointmentQueryDbAdapter(StaffJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<AppointmentRecord> select(String companyCode, String staffNo) {
		return findStaff(companyCode, staffNo).getAppointmentRecordList().getStream().toList();	
	}
	
	private Staff findStaff(String companyCode, String staffNo) {
		return repository.findById(new StaffId(companyCode, staffNo))
						 .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원번호가 존재하지 않습니다."));
	}

}
