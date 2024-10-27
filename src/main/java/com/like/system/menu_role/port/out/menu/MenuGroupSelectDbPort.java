package com.like.system.menu_role.port.out.menu;

import java.util.List;

import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.port.in.menu.dto.MenuGroupQueryDTO;

public interface MenuGroupSelectDbPort {
	MenuGroup select(String companyCode, String menuGroupCode);
	
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
