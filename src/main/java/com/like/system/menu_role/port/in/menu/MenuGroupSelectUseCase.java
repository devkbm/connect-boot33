package com.like.system.menu_role.port.in.menu;

import java.util.List;

import com.like.system.menu_role.port.in.menu.dto.MenuGroupQueryDTO;
import com.like.system.menu_role.port.in.menu.dto.MenuGroupSaveDTO;

public interface MenuGroupSelectUseCase {
	MenuGroupSaveDTO select(String companyCode, String menuGroupCode);
	
	List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto);
}
