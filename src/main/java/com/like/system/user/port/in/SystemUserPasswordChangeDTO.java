package com.like.system.user.port.in;

public record SystemUserPasswordChangeDTO(
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}