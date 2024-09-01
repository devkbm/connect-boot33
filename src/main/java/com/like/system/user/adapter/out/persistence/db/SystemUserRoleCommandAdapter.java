package com.like.system.user.adapter.out.persistence.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRole;
import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRoleId;
import com.like.system.role.adapter.out.persistence.jpa.repository.RoleJpaRepository;
import com.like.system.user.adapter.out.persistence.db.jpa.SystemUserRoleRepository;
import com.like.system.user.application.port.out.SystemUserRoleCommandDbPort;
import com.like.system.user.domain.SystemUserCompanyRole;

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
	public List<JpaRole> select(String companyCode, List<String> roles) {
		return roleRepository.findAllById(roles.stream()
				   			 				   .map(r -> new JpaRoleId(companyCode, r))
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
