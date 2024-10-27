package com.like.system.menu_role.port.in.role.app;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.port.in.role.RoleDeleteUseCase;
import com.like.system.menu_role.port.out.role.RoleCommandDbPort;

@Service
public class RoleDeleteService implements RoleDeleteUseCase {

	RoleCommandDbPort port;

	public RoleDeleteService(RoleCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String roleCode) {
		this.port.delete(companyCode, roleCode);		
	}
	
}
