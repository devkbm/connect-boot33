package com.like.system.user.port.in;

public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
