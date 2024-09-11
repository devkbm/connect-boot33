package com.like.system.role.adapter.out.persistence.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntity;
import com.like.system.role.adapter.out.persistence.db.jpa.QRoleJpaEntity;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntityMapper;
import com.like.system.role.port.in.dto.RoleQueryDTO;
import com.like.system.role.port.out.RoleQueryDbPort;
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
