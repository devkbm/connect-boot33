package com.like.hrm.hrmcode.port.in.hrmcodetype.app;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.port.in.hrmcodetype.HrmCodeTypeSelectUseCase;
import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeSaveDTO;
import com.like.hrm.hrmcode.port.out.HrmCodeTypeCommandDbPort;

@Service
public class HrmCodeTypeSelectService implements HrmCodeTypeSelectUseCase {

	HrmCodeTypeCommandDbPort dbPort;
	
	HrmCodeTypeSelectService(HrmCodeTypeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public HrmCodeTypeSaveDTO select(String id) {
		return HrmCodeTypeSaveDTO.toDTO(this.dbPort.select(id).orElse(null));
	}
	
}
