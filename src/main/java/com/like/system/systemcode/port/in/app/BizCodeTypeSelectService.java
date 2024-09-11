package com.like.system.systemcode.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.port.in.BizCodeTypeSelectUseCase;
import com.like.system.systemcode.port.in.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.port.out.BizCodeTypeSelectPort;

@Service
public class BizCodeTypeSelectService implements BizCodeTypeSelectUseCase {

	BizCodeTypeSelectPort port;
	
	public BizCodeTypeSelectService(BizCodeTypeSelectPort port) {
		this.port = port;
	}

	@Override
	public BizCodeTypeSaveDTO select(String companyCode, String typeId) {
		return this.port.selectDTO(companyCode, typeId);
	}
	
}
