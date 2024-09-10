package com.like.cooperation.workcalendar.port.out;

import java.util.List;

import com.like.cooperation.workcalendar.domain.WorkCalendarMember;

public interface WorkCalendarMemberCommandDbPort {
	
	void save(List<WorkCalendarMember> members);
	
	void delete(List<WorkCalendarMember> members);
}
