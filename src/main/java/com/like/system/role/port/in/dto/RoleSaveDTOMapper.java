package com.like.system.role.port.in.dto;

import com.like.system.role.domain.Role;

public class RoleSaveDTOMapper {
	
	public static Role newEntity(RoleSaveDTO dto) {
		Role entity = new Role(dto.companyCode(), dto.roleCode(), dto.roleName(), dto.description(), dto.menuGroupCode());
		
		//entity.setAppUrl(clientAppUrl);			
		
		return entity;
	}
	
	public static void modifyEntity(Role entity, RoleSaveDTO dto) {		
		entity.modifyEntity(dto.roleName(), dto.description(), dto.menuGroupCode());
		
		//authority.setAppUrl(clientAppUrl);
	}
}
