package com.like.cooperation.workcalendar.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.application.port.in.WorkCalendarSelectUseCase;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarCommandDbPort;
import com.like.cooperation.workcalendar.dto.WorkCalendarSaveDTO;

@Transactional
@Service
public class WorkCalendarSelectService implements WorkCalendarSelectUseCase {

	WorkCalendarCommandDbPort dbPort;
	
	WorkCalendarSelectService(WorkCalendarCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public WorkCalendarSaveDTO select(Long id) {
		return WorkCalendarSaveDTO.toDTO(this.dbPort.select(id));
	}

}
