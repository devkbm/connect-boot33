package com.like.system.menu_role.port.out.menu_role;

import java.util.List;

import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupByRolesSelectDbPort {
	List<MenuGroup> select(String companyCode, List<String> roleCodes);
}
