package com.like.system.role.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRole;
import com.like.system.role.application.port.in.RoleQueryUseCase;
import com.like.system.role.application.port.out.RoleQueryDbPort;
import com.like.system.role.dto.RoleQueryDTO;

@Transactional(readOnly = true)
@Service
public class RoleQueryService implements RoleQueryUseCase {

	private RoleQueryDbPort port;
	
	public RoleQueryService(RoleQueryDbPort port) {
		this.port = port;
	}
		
	@Override
	public List<JpaRole> getAuthorityList(RoleQueryDTO condition) {
		return port.getRoleList(condition);
	}

}
