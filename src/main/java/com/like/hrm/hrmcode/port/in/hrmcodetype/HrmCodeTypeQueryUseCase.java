package com.like.hrm.hrmcode.port.in.hrmcodetype;

import java.util.List;

import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeQueryDTO;
import com.like.hrm.hrmcode.port.in.hrmcodetype.dto.HrmCodeTypeSaveDTO;

public interface HrmCodeTypeQueryUseCase {
	List<HrmCodeTypeSaveDTO> select(HrmCodeTypeQueryDTO dto);
}
