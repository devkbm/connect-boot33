package com.like.login.port.in;

import com.like.login.domain.AuthenticationToken;

public interface AuthenticationTokenSelectUseCase {
	AuthenticationToken select(String companyCode, String userId, String sessionId, String ipAddress);
}
