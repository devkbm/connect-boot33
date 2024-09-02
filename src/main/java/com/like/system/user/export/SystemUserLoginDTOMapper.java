package com.like.system.user.export;

import com.like.system.user.domain.SystemUser;

public class SystemUserLoginDTOMapper {

	public static SystemUserLoginDTO toDTO(SystemUser entity) {
		if (entity == null) return null;
		
		return SystemUserLoginDTO
				.builder()
				.companyCode("001")
				.staffNo(entity.getId().getUserId())
				.authorities(entity.getAuthorities())
				.build();
	}
}
