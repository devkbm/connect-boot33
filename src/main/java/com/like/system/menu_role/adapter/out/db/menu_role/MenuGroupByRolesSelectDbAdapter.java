package com.like.system.menu_role.adapter.out.db.menu_role;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.domain.menu.QMenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu_role.QMenuRoleMapping;
import com.like.system.menu_role.port.out.menu_role.MenuGroupByRolesSelectDbPort;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MenuGroupByRolesSelectDbAdapter implements MenuGroupByRolesSelectDbPort {

	JPAQueryFactory queryFactory;	
	private final QMenuGroup qMenuGroup = QMenuGroup.menuGroup;
	private final QMenuRoleMapping qMenuRoleMapping = QMenuRoleMapping.menuRoleMapping;
	
	MenuGroupByRolesSelectDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	@Override
	public List<MenuGroup> select(String companyCode, List<String> roleCodes) {		
		return this.queryFactory.select(qMenuGroup).distinct()
				                .from(qMenuGroup)
				                .innerJoin(qMenuRoleMapping)
				                .on(qMenuGroup.id.companyCode.eq(qMenuRoleMapping.id.companyCode),
				                	qMenuGroup.id.menuGroupCode.eq(qMenuRoleMapping.id.menuGroupCode))
				                .where(qMenuRoleMapping.id.roleCode.in(roleCodes))
				                .fetch();				               
	}

}