package com.like.system.menu_role.port.in.role.dto;

public record RoleSaveDTO(
		String clientAppUrl,			
		String id,
		String companyCode,
		String roleCode,
		String roleName,
		String description,
		String menuGroupCode
		) {	
}
