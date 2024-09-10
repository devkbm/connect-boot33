package com.like.hrm.hrmcode.port.in.hrmcodetype;

import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeSaveDTO;

public interface HrmCodeTypeSelectUseCase {

	HrmCodeTypeSaveDTO select(String id);
}
