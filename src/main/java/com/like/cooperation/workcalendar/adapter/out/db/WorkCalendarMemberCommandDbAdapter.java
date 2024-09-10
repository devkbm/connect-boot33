package com.like.cooperation.workcalendar.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.adapter.out.db.jpa.WorkCalendarMemberJpaRepository;
import com.like.cooperation.workcalendar.domain.WorkCalendarMember;
import com.like.cooperation.workcalendar.port.out.WorkCalendarMemberCommandDbPort;

@Repository
public class WorkCalendarMemberCommandDbAdapter implements WorkCalendarMemberCommandDbPort {

	WorkCalendarMemberJpaRepository repository;
	
	WorkCalendarMemberCommandDbAdapter(WorkCalendarMemberJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(List<WorkCalendarMember> members) {
		this.repository.saveAll(members);
	}

	@Override
	public void delete(List<WorkCalendarMember> members) {
		this.repository.deleteAll(members);		
	}

}
