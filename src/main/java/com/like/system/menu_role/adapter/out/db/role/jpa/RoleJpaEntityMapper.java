package com.like.system.menu_role.adapter.out.db.role.jpa;

import static org.springframework.util.StringUtils.hasText;

import com.like.system.menu_role.domain.role.Role;
import com.like.system.menu_role.port.in.role.dto.RoleQueryDTO;
//import com.like.system.menu_role.adapter.out.db.role.jpa.QRoleJpaEntity;
import com.querydsl.core.BooleanBuilder;

public class RoleJpaEntityMapper {

	public static RoleJpaEntity toJpaEntity(Role entity) {
		return new RoleJpaEntity(entity.getCompanyCode()
						  ,entity.getRoleCode()
						  ,entity.getRoleName()
						  ,entity.getDescription()
						  ,entity.getMenuGroupCode());
	}
	
	public static Role toEntity(RoleJpaEntity jpaEntity) {
		if (jpaEntity == null) return null; 
		
		return new Role(jpaEntity.getCompanyCode()
					   ,jpaEntity.getRoleCode()
					   ,jpaEntity.getRoleName()
					   ,jpaEntity.getDescription()
					   ,jpaEntity.getMenuGroupCode());			
	}
	
	public static BooleanBuilder toPredicate(RoleQueryDTO dto) {
		BooleanBuilder builder = new BooleanBuilder();
		QRoleJpaEntity qType = QRoleJpaEntity.roleJpaEntity;
			
		builder.and(qType.id.companyCode.eq(dto.companyCode()));
		
		if (hasText(dto.roleCode())) {
			builder.and(qType.id.roleCode.like("%"+dto.roleCode()+"%"));
		}
		
		if (hasText(dto.description())) {
			builder.and(qType.description.like("%"+dto.description()+"%"));
		}
		
		if (hasText(dto.menuGroupCode())) {
			builder.and(qType.menuGroupCode.eq(dto.menuGroupCode()));
		}
		
		return builder;
	}
}
