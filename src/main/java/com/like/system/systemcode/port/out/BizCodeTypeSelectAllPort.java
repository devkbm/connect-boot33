package com.like.system.systemcode.port.out;

import java.util.List;

import com.like.system.systemcode.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectAllPort {
	List<BizCodeTypeSaveDTO> select(String companyCode);
}
