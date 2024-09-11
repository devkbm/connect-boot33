package com.like.system.role.port.in;

import java.util.List;

import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntity;
import com.like.system.role.port.in.dto.RoleQueryDTO;

public interface RoleQueryUseCase {
	List<RoleJpaEntity> getAuthorityList(RoleQueryDTO condition);
}
