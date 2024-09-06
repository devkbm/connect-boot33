package com.like.hrm.staff.port.in.appointment.app;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.port.in.appointment.StaffAppointmentRecordDTO;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentSelectUseCase;
import com.like.hrm.staff.port.out.StaffAppointmentSelectDbPort;

@Service
public class StaffAppointmentSelectService implements StaffAppointmentSelectUseCase {

	StaffAppointmentSelectDbPort dbPort;
	
	StaffAppointmentSelectService(StaffAppointmentSelectDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public StaffAppointmentRecordDTO select(String companyCode, String staffNo, Long seq) {
		return StaffAppointmentRecordDTO.convert(this.dbPort.select(companyCode, staffNo, seq));
	}

	

}
