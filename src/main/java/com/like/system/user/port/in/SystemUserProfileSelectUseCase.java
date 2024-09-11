package com.like.system.user.port.in;

import com.like.system.user.port.in.dto.SystemUserProfileSelectDTO;
import com.like.system.user.port.in.dto.SystemUserProfileSelectSessionDTO;

public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
