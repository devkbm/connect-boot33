package com.like.system.role.adapter.out.persistence.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.role.adapter.out.persistence.db.jpa.JpaRole;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleMapper;
import com.like.system.role.adapter.out.persistence.jpa.entity.QJpaRole;
import com.like.system.role.port.in.RoleQueryDTO;
import com.like.system.role.port.out.RoleQueryDbPort;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class RoleQueryDbAdpater implements RoleQueryDbPort {

	private JPAQueryFactory queryFactory;
	private final QJpaRole qEntity = QJpaRole.jpaRole;	
	
	public RoleQueryDbAdpater(JPAQueryFactory queryFactory) {
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
