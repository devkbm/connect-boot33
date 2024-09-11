package com.like.system.systemcode.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.domain.BizCodeType;
import com.like.system.systemcode.port.in.BizCodeSaveUseCase;
import com.like.system.systemcode.port.in.dto.BizCodeSaveDTOMapper;
import com.like.system.systemcode.port.in.dto.BizCodeSaveDTO;
import com.like.system.systemcode.port.out.BizCodeSavePort;
import com.like.system.systemcode.port.out.BizCodeTypeSelectPort;

@Service
public class BizCodeSaveService implements BizCodeSaveUseCase {

	BizCodeSavePort port;
	BizCodeTypeSelectPort bizCodeTypeSelectPort;
	
	public BizCodeSaveService(BizCodeSavePort port, BizCodeTypeSelectPort bizCodeTypeSelectPort) {	
		this.port = port;
		this.bizCodeTypeSelectPort = bizCodeTypeSelectPort;
	}
	
	@Override
	public void save(BizCodeSaveDTO dto) {
		BizCodeType bizCodeType = bizCodeTypeSelectPort.select(dto.companyCode(), dto.typeId());
		this.port.save(BizCodeSaveDTOMapper.toEntity(dto, bizCodeType));
	}
	
}
