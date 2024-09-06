package com.like.system.user.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.port.in.SystemUserDeleteUseCase;
import com.like.system.user.port.out.SystemUserCommandDbPort;

@Transactional
@Service
public class SystemUserDeleteService implements SystemUserDeleteUseCase {

	SystemUserCommandDbPort port;
	
	SystemUserDeleteService(SystemUserCommandDbPort port) {
		this.port = port;
	}	

	@Override
	public void delete(String userId) {
		this.port.delete(userId);		
	}

}