package com.like.system.systemcode.port.in;

import com.like.system.systemcode.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectUseCase {
	
	BizCodeTypeSaveDTO select(String companyCode, String typeId);
}
