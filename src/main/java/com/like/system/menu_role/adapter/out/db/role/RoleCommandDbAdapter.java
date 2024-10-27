package com.like.system.menu_role.adapter.out.db.role;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntityId;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntityMapper;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaRepository;
import com.like.system.menu_role.domain.role.Role;
import com.like.system.menu_role.port.out.role.RoleCommandDbPort;

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
