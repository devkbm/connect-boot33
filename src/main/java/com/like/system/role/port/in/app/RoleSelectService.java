package com.like.system.role.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.role.domain.Role;
import com.like.system.role.port.in.RoleSelectUseCase;
import com.like.system.role.port.out.RoleCommandDbPort;

@Service
public class RoleSelectService implements RoleSelectUseCase {

	private RoleCommandDbPort port;
	
	public RoleSelectService(RoleCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public Role select(String companyCode, String roleCode) { 
		return port.find(companyCode, roleCode);
	}

}
