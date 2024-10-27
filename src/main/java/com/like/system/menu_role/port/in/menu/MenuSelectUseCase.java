package com.like.system.menu_role.port.in.menu;

import java.util.List;

import com.like.system.menu_role.port.in.menu.dto.MenuQueryDTO;
import com.like.system.menu_role.port.in.menu.dto.MenuSaveDTO;

public interface MenuSelectUseCase {
	MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode);
	
	List<MenuSaveDTO> selectList(MenuQueryDTO dto);
}
