package com.like.system.user.port.in.app.profile;

import org.springframework.stereotype.Service;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.port.in.SystemUserProfileSelectUseCase;
import com.like.system.user.port.in.dto.SystemUserProfileSelectDTO;
import com.like.system.user.port.in.dto.SystemUserProfileSelectDTOMapper;
import com.like.system.user.port.in.dto.SystemUserProfileSelectSessionDTO;
import com.like.system.user.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserProfileSelectService implements SystemUserProfileSelectUseCase {

	SystemUserCommandDbPort dbPort;	
	
	SystemUserProfileSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto) {
		
		SystemUser entity = dbPort.select(userId);
								
		return SystemUserProfileSelectDTOMapper.toDTO(entity, dto);
	}

}
