package com.like.hrm.staff.application.port.out;

import com.like.hrm.staff.domain.model.appointment.AppointmentRecord;

public interface StaffAppointmentSelectDbPort {
	AppointmentRecord select(String companyCode, String staffNo, Long seq);	
}
