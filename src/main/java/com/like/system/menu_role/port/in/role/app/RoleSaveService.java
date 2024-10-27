package com.like.system.menu_role.port.in.role.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.domain.role.Role;
import com.like.system.menu_role.port.in.role.RoleSaveUseCase;
import com.like.system.menu_role.port.in.role.dto.RoleSaveDTO;
import com.like.system.menu_role.port.in.role.dto.RoleSaveDTOMapper;
import com.like.system.menu_role.port.out.role.RoleCommandDbPort;

@Transactional
@Service
public class RoleSaveService implements RoleSaveUseCase {

	RoleCommandDbPort dbPort;	
	
	public RoleSaveService(RoleCommandDbPort dbPort) {
		this.dbPort = dbPort;		
	}

	@Override
	public void save(RoleSaveDTO dto) {
		Role entity = dbPort.find(dto.companyCode(), dto.roleCode());			
		
		if (entity == null) {
			entity = RoleSaveDTOMapper.newEntity(dto);
		} else {
			RoleSaveDTOMapper.modifyEntity(entity, dto);			
		}
		
		dbPort.save(entity);		
	}
	
}
