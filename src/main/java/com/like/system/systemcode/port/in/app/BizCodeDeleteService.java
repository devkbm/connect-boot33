package com.like.system.systemcode.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.port.in.BizCodeDeleteUseCase;
import com.like.system.systemcode.port.out.BizCodeDeletePort;

@Service
public class BizCodeDeleteService implements BizCodeDeleteUseCase {

	BizCodeDeletePort port;
	
	public BizCodeDeleteService(BizCodeDeletePort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId, String code) {
		this.port.delete(companyCode, typeId, code);		
	}

	
}
