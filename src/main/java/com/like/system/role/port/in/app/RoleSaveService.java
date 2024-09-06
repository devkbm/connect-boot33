package com.like.system.role.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.role.domain.Role;
import com.like.system.role.port.in.RoleSaveDTO;
import com.like.system.role.port.in.RoleSaveUseCase;
import com.like.system.role.port.out.RoleCommandDbPort;

@Transactional
@Service
public class RoleSaveService implements RoleSaveUseCase {

	RoleCommandDbPort dbPort;	
	
	public RoleSaveService(RoleCommandDbPort dbPort) {
		this.dbPort = dbPort;		
	}

	@Override
	public void save(RoleSaveDTO dto) {
		Role authority = dbPort.find(dto.companyCode(), dto.roleCode());			
		
		if (authority == null) {
			authority = dto.newEntity();
		} else {
			dto.modifyEntity(authority);
		}
		
		dbPort.save(authority);		
	}
	
}
