package com.like.hrm.hrmcode.port.in.hrmcode;

import java.util.List;
import java.util.Map;

import com.like.hrm.hrmcode.port.in.hrmcode.dto.HrmCodeQueryDTO;
import com.like.hrm.hrmcode.port.in.hrmcode.dto.HrmCodeSaveDTO;

public interface HrmCodeQueryUseCase {
	List<HrmCodeSaveDTO> select(HrmCodeQueryDTO dto);
	
	Map<String, List<HrmCodeSaveDTO>> selectCodeList(List<String> typeIds);
}
