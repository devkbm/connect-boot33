package com.like.system.menurole.application.port.out;

import java.util.List;

import com.like.system.menu.domain.MenuGroup;

public interface MenuGroupByRolesSelectDbPort {
	List<MenuGroup> select(String companyCode, List<String> roleCodes);
}
