package com.like.system.user.application.port.out;

import java.util.List;

import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRole;
import com.like.system.user.domain.SystemUserCompanyRole;

public interface SystemUserRoleCommandDbPort {
	List<JpaRole> select(String companyCode, List<String> roles);
	
	void save(List<SystemUserCompanyRole> roleList);
	
	void delete(List<SystemUserCompanyRole> roleList);
}
