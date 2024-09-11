package com.like.system.systemcode.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.port.in.BizCodeSelectUseCase;
import com.like.system.systemcode.port.in.dto.BizCodeSaveDTO;
import com.like.system.systemcode.port.out.BizCodeSelectPort;

@Service
public class BizCodeSelectService implements BizCodeSelectUseCase {
	
	BizCodeSelectPort port;
	
	public BizCodeSelectService(BizCodeSelectPort port) {		
		this.port = port;
	}
	
	@Override
	public BizCodeSaveDTO select(String companyCode, String typeId, String code) {						
		return this.port.selectDTO(companyCode, typeId, code);
	}
	
}
