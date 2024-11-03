package com.like.system.menu_role.port.in.role.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.port.in.role.RoleQueryUseCase;
import com.like.system.menu_role.port.in.role.dto.RoleQueryDTO;
import com.like.system.menu_role.port.out.role.RoleQueryDbPort;

@Transactional(readOnly = true)
@Service
public class RoleQueryService implements RoleQueryUseCase {

	private RoleQueryDbPort port;
	
	public RoleQueryService(RoleQueryDbPort port) {
		this.port = port;
	}
		
	@Override
	public List<RoleJpaEntity> getAuthorityList(RoleQueryDTO condition) {
		return port.getRoleList(condition);
	}

}