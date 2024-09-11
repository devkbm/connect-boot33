package com.like.system.systemcode.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.port.in.BizCodeTypeDeleteUseCase;
import com.like.system.systemcode.port.out.BizCodeTypeDeletePort;

@Service
public class BizCodeTypeDeleteService implements BizCodeTypeDeleteUseCase {

	BizCodeTypeDeletePort port;
	
	public BizCodeTypeDeleteService(BizCodeTypeDeletePort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.port.delete(companyCode, typeId);		
	}
	
	
}
