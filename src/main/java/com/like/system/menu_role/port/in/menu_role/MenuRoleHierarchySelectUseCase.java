package com.like.system.menu_role.port.in.menu_role;

import java.util.List;

public interface MenuRoleHierarchySelectUseCase {
	List<?> select(String companyCode, String menuGroupCode, String roleCode);
}