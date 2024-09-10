package com.like.hrm.hrmcode.port.in.hrmcode.app;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.domain.HrmCodeId;
import com.like.hrm.hrmcode.port.in.hrmcode.HrmCodeSelectUseCase;
import com.like.hrm.hrmcode.port.in.hrmcode.dto.HrmCodeSaveDTO;
import com.like.hrm.hrmcode.port.out.HrmCodeCommandDbPort;

@Service
public class HrmCodeSelectService implements HrmCodeSelectUseCase {

	HrmCodeCommandDbPort dbPort;
	
	HrmCodeSelectService(HrmCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public HrmCodeSaveDTO select(String type, String code) {	
		return HrmCodeSaveDTO.toDTO(this.dbPort.select(new HrmCodeId(type, code)).orElse(null));
	}

}
