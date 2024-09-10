package com.like.cooperation.workcalendar.port.out;

import java.util.List;

import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;
import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarEventQueryDTO;

public interface WorkCalendarEventQueryDbPort {

	List<WorkCalendarEvent> getScheduleList(WorkCalendarEventQueryDTO searchCondition);
}
