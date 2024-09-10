package com.like.hrm.staff.port.in.appointment.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.appointment.AppointmentRecord;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentRecordDTO;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentSaveUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffAppointmentSaveService implements StaffAppointmentSaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffAppointmentSaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(StaffAppointmentRecordDTO dto) {		
		
		Staff staff = dbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));		
		AppointmentRecord entity = staff.getAppointmentRecordList().get(staff, dto.seq());
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		
		staff.getAppointmentRecordList().add(entity);		
		staff.applyAppointmentRecord(entity);		 
		
		dbPort.save(staff);
	}
	
}
