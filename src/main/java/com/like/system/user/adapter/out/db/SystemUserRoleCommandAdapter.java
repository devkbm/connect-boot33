package com.like.system.user.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntity;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntityId;
import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaRepository;
import com.like.system.user.adapter.out.db.jpa.SystemUserRoleRepository;
import com.like.system.user.domain.SystemUserCompanyRole;
import com.like.system.user.port.out.SystemUserRoleCommandDbPort;

@Repository
public class SystemUserRoleCommandAdapter implements SystemUserRoleCommandDbPort {

	SystemUserRoleRepository repository;
	RoleJpaRepository roleRepository;
	
	SystemUserRoleCommandAdapter(SystemUserRoleRepository repository,
							  RoleJpaRepository roleRepository) {
		this.repository = repository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleJpaEntity> select(String companyCode, List<String> roles) {
		return roleRepository.findAllById(roles.stream()
				   			 				   .map(r -> new RoleJpaEntityId(companyCode, r))
				   			 				   .toList());
	}

	@Override
	public void save(List<SystemUserCompanyRole> roleList) {
		repository.saveAll(roleList);
	}

	@Override
	public void delete(List<SystemUserCompanyRole> roleList) {
		repository.deleteAll(roleList);		
	}
	
}
