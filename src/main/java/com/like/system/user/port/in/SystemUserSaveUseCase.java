package com.like.system.user.port.in;

import java.util.List;

import com.like.system.user.port.in.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.port.in.dto.SystemUserSaveDTO;

public interface SystemUserSaveUseCase {
	void save(SystemUserSaveDTO dto);
	
	void save(List<SystemUserSaveByExcelDTO> dto);
}
