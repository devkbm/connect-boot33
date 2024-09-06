package com.like.system.user.port.in;

public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
