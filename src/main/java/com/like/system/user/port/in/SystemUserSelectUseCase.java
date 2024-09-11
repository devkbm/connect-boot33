package com.like.system.user.port.in;

import com.like.system.user.port.in.dto.SystemUserSelectDTO;

public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
