package com.like.system.menu.port.in.dto;

import com.like.system.menu.domain.Menu;
import com.like.system.menu.domain.MenuGroup;
import com.like.system.menu.domain.MenuType;

public class MenuSaveDTOMapper {

	public static MenuSaveDTO toDTO(Menu entity) {
		
		return MenuSaveDTO.builder()
				   	   .createdDt(entity.getCreatedDt())
				   	   .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				   	   .modifiedDt(entity.getModifiedDt())
				   	   .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())					   	   
				   	   .companyCode(entity.getMenuGroup().getId().getCompanyCode())
				   	   .menuGroupCode(entity.getMenuGroup().getId().getMenuGroupCode())					   	   					   	   
				   	   .menuCode(entity.getId().getMenuCode())
				   	   .menuName(entity.getName())
				   	   .menuType(entity.getType().toString())
				   	   .appUrl(entity.getAppUrl())
				   	   .sequence(entity.getSequence())
				   	   .level(entity.getLevel())
				   	   .parentMenuCode(entity.getParentMenuCode())					   	   
				   	   .build();
	}
	
	public static Menu toEntity(MenuSaveDTO dto, MenuGroup menuGroup, Menu parentMenu) {
		Menu entity = Menu.builder()
						  .menuGroup(menuGroup)
						  .parent(parentMenu)
						  .companyCode(dto.companyCode())
						  .menuCode(dto.menuCode())
						  .menuName(dto.menuName())
						  .menuType(MenuType.valueOf(dto.menuType()))
						  .sequence(dto.sequence())
						  .level(dto.level())					   
						  .appUrl(dto.appUrl())
						  .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}

}
