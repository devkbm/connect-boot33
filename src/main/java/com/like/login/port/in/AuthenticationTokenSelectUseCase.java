package com.like.login.port.in;

import com.like.login.domain.AuthenticationToken;

public interface AuthenticationTokenSelectUseCase {
	AuthenticationToken select(String userId, String companyCode, String sessionId, String ipAddress);
}
