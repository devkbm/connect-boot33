package com.like.system.user.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.vo.UserPassword;
import com.like.system.user.port.in.SystemUserPasswordChangeUseCase;
import com.like.system.user.port.in.SystemUserPasswordInitUseCase;
import com.like.system.user.port.in.dto.SystemUserPasswordChangeDTO;
import com.like.system.user.port.out.SystemUserCommandDbPort;

@Transactional
@Service
public class SystemUserPasswordService implements SystemUserPasswordChangeUseCase, SystemUserPasswordInitUseCase {

	SystemUserCommandDbPort dbPort;
	PasswordEncoder passwordEncoder;
	
	SystemUserPasswordService(SystemUserCommandDbPort dbPort
							 ,PasswordEncoder passwordEncoder) {
		this.dbPort = dbPort;		
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void changePassword(SystemUserPasswordChangeDTO dto) {
		SystemUser user = dbPort.select(dto.userId());			
		
		if ( user.isVaild(dto.beforePassword()) ) {
			user.changePassword(passwordEncoder.encode(dto.afterPassword()));
		} 		
	}

	@Override
	public void initPassword(String companyCode, String userId) {
		SystemUser user = dbPort.select(userId);
		
		user.changePassword(UserPassword.getInitPassword());		
	}

}
