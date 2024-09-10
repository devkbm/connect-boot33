package com.like.hrm.hrmcode.port.in.hrmcode.app;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.domain.HrmCodeId;
import com.like.hrm.hrmcode.port.in.hrmcode.HrmCodeDeleteUseCase;
import com.like.hrm.hrmcode.port.out.HrmCodeCommandDbPort;

@Service
public class HrmCodeDeleteService implements HrmCodeDeleteUseCase {

	HrmCodeCommandDbPort dbPort;

	HrmCodeDeleteService(HrmCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String type, String code) {
		this.dbPort.delete(new HrmCodeId(type, code));
	}
}
