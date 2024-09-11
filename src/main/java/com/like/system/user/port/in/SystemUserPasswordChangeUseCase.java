package com.like.system.user.port.in;

import com.like.system.user.port.in.dto.SystemUserPasswordChangeDTO;

public interface SystemUserPasswordChangeUseCase {
	void changePassword(SystemUserPasswordChangeDTO dto);
}
