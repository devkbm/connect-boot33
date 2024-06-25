package com.like.system.user.application.export;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.export.SystemUserDTO;
import com.like.system.user.export.SystemUserDTOSelectUseCase;

@Service
public class SystemUserDTOSelectService implements SystemUserDTOSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserDTOSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserDTO findUser(String companyCode, String userId) {
		return SystemUserDTO.toDTO(this.dbPort.select(companyCode, userId));
	}

	@Override
	public List<SystemUserDTO> findUsers(String companyCode, List<String> userId) {
		
		return this.dbPort.select(companyCode, userId)
						  .stream()
						  .map(e -> SystemUserDTO.toDTO(e))
						  .toList();
						  
	}

}
