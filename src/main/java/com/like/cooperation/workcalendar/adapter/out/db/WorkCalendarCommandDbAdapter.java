package com.like.cooperation.workcalendar.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.adapter.out.db.jpa.WorkCalendarJpaRepository;
import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.port.out.WorkCalendarCommandDbPort;

@Repository
public class WorkCalendarCommandDbAdapter implements WorkCalendarCommandDbPort {

	WorkCalendarJpaRepository repository;
	
	WorkCalendarCommandDbAdapter(WorkCalendarJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public WorkCalendar select(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void save(WorkCalendar entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);		
	}

}
