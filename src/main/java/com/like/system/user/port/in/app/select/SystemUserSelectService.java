package com.like.system.user.port.in.app.select;

import org.springframework.stereotype.Service;

import com.like.system.user.port.in.SystemUserSelectDTO;
import com.like.system.user.port.in.SystemUserSelectUseCase;
import com.like.system.user.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserSelectService implements SystemUserSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public SystemUserSelectDTO selectDTO(String userId, String companyCode) {
		return SystemUserSelectDTOMapper.toDTO(this.dbPort.select(userId), companyCode);
	}
}
