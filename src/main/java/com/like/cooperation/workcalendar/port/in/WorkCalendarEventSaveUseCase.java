package com.like.cooperation.workcalendar.port.in;

import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarEventSaveDTO;

public interface WorkCalendarEventSaveUseCase {

	void save(WorkCalendarEventSaveDTO dto);
}
