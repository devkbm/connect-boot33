package com.like.system.role.port.out;

import java.util.List;

import com.like.system.role.adapter.out.persistence.db.jpa.RoleJpaEntity;
import com.like.system.role.port.in.dto.RoleQueryDTO;

public interface RoleQueryDbPort {

	/**
	 * 전체 권한 도메인 리스트를 조회한다.
	 * @return	권한 도메인 리스트
	 */
	List<RoleJpaEntity> getRoleList(RoleQueryDTO dto);
	
}
