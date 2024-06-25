package com.like.hrm.staff.application.service.appointment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.appointment.StaffAppointmentQueryUseCase;
import com.like.hrm.staff.application.port.out.StaffAppointmentQueryDbPort;
import com.like.hrm.staff.dto.StaffAppointmentRecordDTO;

@Transactional(readOnly = true)
@Service
public class StaffAppointmentQueryService implements StaffAppointmentQueryUseCase {
	
	StaffAppointmentQueryDbPort dbPort;
	
	StaffAppointmentQueryService(StaffAppointmentQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffAppointmentRecordDTO> select(String companyCode, String staffNo) {
		return this.dbPort.select(companyCode, staffNo)
						  .stream()
						  .map(e -> StaffAppointmentRecordDTO.convert(e))
						  .toList();
	}
}
