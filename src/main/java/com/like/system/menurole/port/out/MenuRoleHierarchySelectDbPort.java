package com.like.system.menurole.port.out;

import java.util.List;

import com.like.system.menurole.domain.MenuRoleHierarchy;

public interface MenuRoleHierarchySelectDbPort {
	List<MenuRoleHierarchy> select(String companyCode, String menuGroupCode, String roleCode);
}
