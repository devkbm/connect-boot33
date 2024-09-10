package com.like.cooperation.workcalendar.port.out;

import java.util.List;

import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarQueryDTO;

public interface WorkCalendarQueryDbPort {
	public List<WorkCalendar> getWorkGroupList(WorkCalendarQueryDTO searchCondition);
	
	public List<WorkCalendar> getWorkGroupList(String userId);
}
