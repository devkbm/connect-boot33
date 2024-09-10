package com.like.hrm.hrmcode.port.in.hrmcodetype.app;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.like.hrm.hrmcode.domain.HrmCodeType;
import com.like.hrm.hrmcode.port.in.hrmcodetype.HrmCodeTypeSaveUseCase;
import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeSaveDTO;
import com.like.hrm.hrmcode.port.out.HrmCodeTypeCommandDbPort;

@Service
public class HrmCodeTypeSaveService implements HrmCodeTypeSaveUseCase {

	HrmCodeTypeCommandDbPort dbPort;
	
	HrmCodeTypeSaveService(HrmCodeTypeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HrmCodeTypeSaveDTO dto) {

		HrmCodeType hrmType = null;
		
		if (StringUtils.hasText(dto.typeId())) hrmType = dbPort.select(dto.typeId()).orElse(null);		
		
		if (hrmType == null) {
			hrmType = dto.newEntity();
		} else {					
			hrmType = dto.modify(hrmType);
		}		
		dbPort.save(hrmType);	
	}
	
}
