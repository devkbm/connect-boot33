package com.like.system.menu.port.in;

import java.util.List;

public interface MenuHierarchySelectUseCase {

	List<MenuHierarchyNgZorro> select(String companyCode, String menuGroupCode);	
}
