package com.like.system.role.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.role.port.in.RoleDeleteUseCase;
import com.like.system.role.port.out.RoleCommandDbPort;

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
