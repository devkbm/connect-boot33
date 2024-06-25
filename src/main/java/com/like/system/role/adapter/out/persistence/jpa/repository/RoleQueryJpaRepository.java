package com.like.system.role.adapter.out.persistence.jpa.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.role.adapter.out.persistence.jpa.entity.RoleMapper;
import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRole;
import com.like.system.role.adapter.out.persistence.jpa.entity.QJpaRole;
import com.like.system.role.application.port.out.RoleQueryDbPort;
import com.like.system.role.dto.RoleQueryDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class RoleQueryJpaRepository implements RoleQueryDbPort {

	private JPAQueryFactory queryFactory;
	private final QJpaRole qEntity = QJpaRole.jpaRole;	
	
	public RoleQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<JpaRole> getRoleList(RoleQueryDTO dto) {		
		return queryFactory
				.selectFrom(qEntity)
				.where(RoleMapper.toPredicate(dto))
				.fetch();
		
	}

}
