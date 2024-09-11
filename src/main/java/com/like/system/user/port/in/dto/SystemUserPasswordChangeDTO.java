package com.like.system.user.port.in.dto;

public record SystemUserPasswordChangeDTO(
		String companyCode,
		String userId,
		String beforePassword,
		String afterPassword
		) {	
}