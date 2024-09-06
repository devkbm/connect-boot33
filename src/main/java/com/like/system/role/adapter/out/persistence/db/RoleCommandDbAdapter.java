package com.like.system.role.adapter.out.persistence.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.role.adapter.out.persistence.db.jpa.JpaRole;
import com.like.system.role.adapter.out.persistence.db.jpa.JpaRoleId;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaRepository;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleMapper;
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
		JpaRole entity = this.jpaRepository.findById(new JpaRoleId(companyCode, roleCode)).orElse(null);
		
		return RoleMapper.toEntity(entity);
	}

	@Override
	public void save(Role role) {
		this.jpaRepository.save(RoleMapper.toJpaEntity(role));		
	}
	
	@Override
	public void delete(String companyCode, String roleCode) {
		this.jpaRepository.deleteById(new JpaRoleId(companyCode, roleCode));		
	}
}
