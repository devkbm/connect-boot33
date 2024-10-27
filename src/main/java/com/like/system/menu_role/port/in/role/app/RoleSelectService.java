package com.like.system.menu_role.port.in.role.app;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.domain.role.Role;
import com.like.system.menu_role.port.in.role.RoleSelectUseCase;
import com.like.system.menu_role.port.out.role.RoleCommandDbPort;

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
