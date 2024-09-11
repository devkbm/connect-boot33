package com.like.system.role.adapter.out.persistence.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntity;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntityId;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaRepository;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntityMapper;
import com.like.system.role.domain.Role;
import com.like.system.role.port.out.RoleCommandDbPort;

@Repository
@Transactional
public class RoleCommandDbAdapter implements RoleCommandDbPort {

	RoleJpaRepository jpaRepository;
	
	public RoleCommandDbAdapter(RoleJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Role find(String companyCode, String roleCode) {
		RoleJpaEntity entity = this.jpaRepository.findById(new RoleJpaEntityId(companyCode, roleCode)).orElse(null);
		
		return RoleJpaEntityMapper.toEntity(entity);
	}

	@Override
	public void save(Role role) {
		this.jpaRepository.save(RoleJpaEntityMapper.toJpaEntity(role));		
	}
	
	@Override
	public void delete(String companyCode, String roleCode) {
		this.jpaRepository.deleteById(new RoleJpaEntityId(companyCode, roleCode));		
	}
}
