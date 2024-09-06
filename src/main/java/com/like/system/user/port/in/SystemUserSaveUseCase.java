package com.like.system.user.port.in;

import java.util.List;

public interface SystemUserSaveUseCase {
	void save(SystemUserSaveDTO dto);
	
	void save(List<SystemUserSaveByExcelDTO> dto);
}
