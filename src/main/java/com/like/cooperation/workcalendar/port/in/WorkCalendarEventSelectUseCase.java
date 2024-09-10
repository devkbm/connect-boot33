package com.like.cooperation.workcalendar.port.in;

import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarEventResponseDTO;

public interface WorkCalendarEventSelectUseCase {
	WorkCalendarEventResponseDTO select(Long id);
}
