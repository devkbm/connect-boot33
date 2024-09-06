package com.like.system.role.port.in;

import java.util.List;

import com.like.system.role.adapter.out.persistence.db.jpa.JpaRole;

public interface RoleQueryUseCase {
	List<JpaRole> getAuthorityList(RoleQueryDTO condition);
}
