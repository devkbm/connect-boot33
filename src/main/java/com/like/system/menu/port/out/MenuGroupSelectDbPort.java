package com.like.system.menu.port.out;

import java.util.List;

import com.like.system.menu.domain.MenuGroup;
import com.like.system.menu.port.in.dto.MenuGroupQueryDTO;

public interface MenuGroupSelectDbPort {
	MenuGroup select(String companyCode, String menuGroupCode);
	
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
