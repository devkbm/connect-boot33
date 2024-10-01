package com.like.system.menu.port.in.dto;

import com.like.system.menu.domain.MenuGroup;

public class MenuGroupSaveDTOMapper {

	public static MenuGroupSaveDTO toDTO(MenuGroup entity) {
		if (entity == null) return null;
		
		return MenuGroupSaveDTO.builder()
							.createdDt(entity.getCreatedDt())
							.createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
							.modifiedDt(entity.getModifiedDt())
							.modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())								
							.companyCode(entity.getId().getCompanyCode())
							//.menuGroupId(entity.getId())
							.menuGroupCode(entity.getId().getMenuGroupCode())
							.menuGroupName(entity.getName())
							.menuGroupUrl(entity.getMenuGroupUrl())
							.description(entity.getDescription())
							.build();
	}
	
	public static MenuGroup newMenuGroup(MenuGroupSaveDTO dto) {
		MenuGroup entity = MenuGroup.builder()
								    .companyCode(dto.companyCode())
								    .code(dto.menuGroupCode())
								    .name(dto.menuGroupName())
								    .menuGroupUrl(dto.menuGroupUrl())
								    .description(dto.description())						    
								    .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;	
	}
	
	public static void modifyMenuGroup(MenuGroupSaveDTO dto, MenuGroup menuGroup) {
		menuGroup.modifyEntity(dto.menuGroupName(), dto.menuGroupUrl(), dto.description());
		
		menuGroup.setAppUrl(dto.clientAppUrl());
	}	
	
}