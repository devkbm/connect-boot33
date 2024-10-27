package com.like.system.menu_role.port.out.menu;

import java.util.List;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.port.in.menu.dto.MenuQueryDTO;

public interface MenuSelectDbPort {
	Menu select(String companyCode, String menuGroupCode, String menuCode);
	
	List<Menu> selectList(MenuQueryDTO dto);
}
