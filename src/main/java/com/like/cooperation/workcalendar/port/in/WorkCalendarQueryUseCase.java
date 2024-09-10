package com.like.cooperation.workcalendar.port.in;

import java.util.List;

import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarQueryDTO;

public interface WorkCalendarQueryUseCase {

	public List<WorkCalendar> getWorkGroupList(WorkCalendarQueryDTO searchCondition);
	
	public List<WorkCalendar> getWorkGroupList(String userId);
}
