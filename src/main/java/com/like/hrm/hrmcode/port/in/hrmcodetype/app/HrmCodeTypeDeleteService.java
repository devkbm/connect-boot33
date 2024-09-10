package com.like.hrm.hrmcode.port.in.hrmcodetype.app;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.port.in.hrmcodetype.HrmCodeTypeDeleteUseCase;
import com.like.hrm.hrmcode.port.out.HrmCodeTypeCommandDbPort;

@Service
public class HrmCodeTypeDeleteService implements HrmCodeTypeDeleteUseCase {

	HrmCodeTypeCommandDbPort dbPort;
	
	HrmCodeTypeDeleteService(HrmCodeTypeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String id) {
		dbPort.delete(id);
	}

}
