package com.like.system.user.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.jpa.SystemUserRepository;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;
import com.like.system.user.port.out.SystemUserCommandDbPort;


@Repository
public class SystemUserCommandDbAdapter implements SystemUserCommandDbPort {

	SystemUserRepository repository;	
	
	SystemUserCommandDbAdapter(SystemUserRepository repository) {
		this.repository = repository;			
	}
	
	@Override
	public SystemUser select(String userId) {		
		return this.repository.findById(new SystemUserId(userId)).orElse(null);
	}
	
	@Override
	public void save(SystemUser entity) {
		this.repository.save(entity);		
	}
	
	@Override
	public void delete(String userId) {
		this.repository.deleteById(new SystemUserId(userId));		
	}

	@Override
	public List<SystemUser> select(List<String> userIds) {	
		return this.repository.findAllById(userIds.stream().map(e -> new SystemUserId(e)).toList());
	}
				
}
