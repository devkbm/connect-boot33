package com.like.system.holiday.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.holiday.port.in.HolidaySaveDTO;
import com.like.system.holiday.port.in.HolidaySaveUseCase;
import com.like.system.holiday.port.out.HolidaySavePort;

@Service
public class HolidaySaveService implements HolidaySaveUseCase {

	HolidaySavePort port;
	
	public HolidaySaveService(HolidaySavePort port) {
		this.port = port;
	}
	
	@Override
	public void save(HolidaySaveDTO dto) {	
		this.port.save(dto.newEntity());
	}

}
