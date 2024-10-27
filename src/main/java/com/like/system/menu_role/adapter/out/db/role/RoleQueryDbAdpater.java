package com.like.system.menu_role.adapter.out.db.role;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntityMapper;
import com.like.system.menu_role.adapter.out.db.role.jpa.QRoleJpaEntity;
import com.like.system.menu_role.port.in.role.dto.RoleQueryDTO;
import com.like.system.menu_role.port.out.role.RoleQueryDbPort;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class RoleQueryDbAdpater implements RoleQueryDbPort {

	private JPAQueryFactory queryFactory;
	private final QRoleJpaEntity qEntity = QRoleJpaEntity.roleJpaEntity;	
	
	public RoleQueryDbAdpater(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<RoleJpaEntity> getRoleList(RoleQueryDTO dto) {		
		return queryFactory
				.selectFrom(qEntity)
				.where(RoleJpaEntityMapper.toPredicate(dto))
				.fetch();
		
	}

}
