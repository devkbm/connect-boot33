package com.like.system.menu_role.port.in.menu;

import java.util.List;

public interface MenuHierarchySelectUseCase {

	List<MenuHierarchyNgZorro> select(String companyCode, String menuGroupCode);	
}
