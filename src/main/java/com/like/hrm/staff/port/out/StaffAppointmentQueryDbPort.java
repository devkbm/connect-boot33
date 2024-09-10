package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.domain.appointment.AppointmentRecord;

public interface StaffAppointmentQueryDbPort {
	List<AppointmentRecord> select(String companyCode, String staffNo);
}
