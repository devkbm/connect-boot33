package com.like.system.user.application.port.in;

import com.like.system.user.dto.SystemUserSaveDTO;

public interface SystemUserSelectUseCase {
	SystemUserSaveDTO selectDTO(String companyCode, String userId);	
}
