package com.like.hrm.staff.port.in.appointment;

import java.util.List;

public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentRecordDTO> select(String companyCode, String staffNo);
}
