package com.like.system.role.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.role.domain.Role;
import com.like.system.role.port.in.RoleSaveUseCase;
import com.like.system.role.port.in.dto.RoleSaveDTO;
import com.like.system.role.port.in.dto.RoleSaveDTOMapper;
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
		Role entity = dbPort.find(dto.companyCode(), dto.roleCode());			
		
		if (entity == null) {
			entity = RoleSaveDTOMapper.newEntity(dto);
		} else {
			RoleSaveDTOMapper.modifyEntity(entity, dto);			
		}
		
		dbPort.save(entity);		
	}
	
}
