package com.like.system.systemcode.port.in;

import java.util.List;

import com.like.system.systemcode.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectAllUseCase {

	List<BizCodeTypeSaveDTO> select(String companyCode);
}
