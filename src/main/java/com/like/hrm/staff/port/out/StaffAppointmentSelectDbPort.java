package com.like.hrm.staff.port.out;

import com.like.hrm.staff.domain.appointment.AppointmentRecord;

public interface StaffAppointmentSelectDbPort {
	AppointmentRecord select(String companyCode, String staffNo, Long seq);	
}
