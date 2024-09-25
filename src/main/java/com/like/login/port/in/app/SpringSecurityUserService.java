package com.like.login.port.in.app;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.login.domain.CustomUserDetails;
import com.like.system.user.adapter.out.db.jpa.SystemUserRepository;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;

@Transactional
@Service
public class SpringSecurityUserService implements UserDetailsService {

	private SystemUserRepository repository;
	
	public SpringSecurityUserService(SystemUserRepository repository) {
		this.repository = repository;		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		SystemUser user = repository.findById(new SystemUserId(username))
				 					.orElseThrow(() -> new UsernameNotFoundException(username + " is Not Found"));
					
		return CustomUserDetails.builder()
								.userId(user.getId().getUserId())
								.password(user.getPassword())								
								.build();
	}

}
