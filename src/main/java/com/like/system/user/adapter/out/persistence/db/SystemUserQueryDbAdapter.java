package com.like.system.user.adapter.out.persistence.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.persistence.db.jpa.SystemUserRepository;
import com.like.system.user.application.port.in.SystemUserQueryDTO;
import com.like.system.user.application.port.out.SystemUserQueryDbPort;
import com.like.system.user.domain.SystemUser;

@Repository
public class SystemUserQueryDbAdapter implements SystemUserQueryDbPort {

	SystemUserRepository repository;
	
	SystemUserQueryDbAdapter(SystemUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<SystemUser> selectList(SystemUserQueryDTO dto) {
		return this.repository.findAll(dto.getBooleanBuilder());
	}
	
	
}
