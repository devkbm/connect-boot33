package com.like.cooperation.workcalendar.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.port.in.WorkCalendarQueryUseCase;
import com.like.cooperation.workcalendar.port.in.dto.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.port.out.WorkCalendarQueryDbPort;

@Transactional(readOnly=true)
@Service
public class WorkCalendarQueryService implements WorkCalendarQueryUseCase {
				
	WorkCalendarQueryDbPort dbPort;
	
	public WorkCalendarQueryService(WorkCalendarQueryDbPort dbPort) {		
		this.dbPort = dbPort;
	}

	@Override
	public List<WorkCalendar> getWorkGroupList(WorkCalendarQueryDTO searchCondition) {
		return this.dbPort.getWorkGroupList(searchCondition);
	}

	@Override
	public List<WorkCalendar> getWorkGroupList(String userId) {
		return this.dbPort.getWorkGroupList(userId);
	}	
}