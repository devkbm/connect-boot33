package com.like.system.user.application.port.in;

import java.util.List;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.dto.SystemUserQueryDTO;

public interface SystemUserQueryRepository {

	/**
	 * 유저 도메인 리스트를 조회한다.
	 * @return	유저 도메인 리스트
	 */
	List<SystemUser> getUserList(SystemUserQueryDTO condition);
	
}
