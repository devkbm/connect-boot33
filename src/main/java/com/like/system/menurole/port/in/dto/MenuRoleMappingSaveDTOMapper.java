package com.like.system.menurole.port.in.dto;

import com.like.system.menurole.domain.MenuRoleMapping;
import com.like.system.menurole.domain.MenuRoleMappingId;

public class MenuRoleMappingSaveDTOMapper {

	public static MenuRoleMapping toEntity(MenuRoleMappingSaveDTO dto) {
		MenuRoleMapping entity = new MenuRoleMapping(new MenuRoleMappingId(dto.companyCode(), dto.menuGroupCode(), dto.menuCode(), dto.roleCode()));
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
}
