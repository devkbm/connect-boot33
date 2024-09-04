package com.like.system.user.application.port.in;

public record SystemUserPasswordChangeDTO(
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}