package com.like.cooperation.workcalendar.port.in;

import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarSaveDTO;

public interface WorkCalendarSelectUseCase {

	WorkCalendarSaveDTO select(Long id);
}
