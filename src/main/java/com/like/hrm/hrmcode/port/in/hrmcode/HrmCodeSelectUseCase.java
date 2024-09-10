package com.like.hrm.hrmcode.port.in.hrmcode;

import com.like.hrm.hrmcode.port.in.hrmcode.dto.HrmCodeSaveDTO;

public interface HrmCodeSelectUseCase {
	HrmCodeSaveDTO select(String type, String code);
}
