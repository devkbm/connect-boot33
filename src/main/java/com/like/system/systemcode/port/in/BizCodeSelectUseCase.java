package com.like.system.systemcode.port.in;

import com.like.system.systemcode.port.in.dto.BizCodeSaveDTO;

public interface BizCodeSelectUseCase {
	BizCodeSaveDTO select(String companyCode, String typeId, String code);	
}
