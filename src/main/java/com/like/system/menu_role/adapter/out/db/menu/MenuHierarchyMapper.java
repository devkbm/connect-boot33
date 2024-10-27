package com.like.system.menu_role.adapter.out.db.menu;

import com.like.system.menu_role.domain.menu.MenuHierarchy;
import com.like.system.menu_role.domain.menu.QMenu;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;

public class MenuHierarchyMapper {

	public static QBean<MenuHierarchy> map(QMenu qMenu) {
		
		return Projections.fields(MenuHierarchy.class,
				qMenu.id.menuGroupId.companyCode,
				qMenu.id.menuGroupId.menuGroupCode,
				qMenu.id.menuCode,
				qMenu.name.as("menuName"),
				qMenu.type.as("menuType"),
				qMenu.appUrl,
				qMenu.appIcon.appIconType,
				qMenu.appIcon.appIcon,
				qMenu.sequence,
				qMenu.level,						
				qMenu.parentMenuCode
				);
	}
	
}
