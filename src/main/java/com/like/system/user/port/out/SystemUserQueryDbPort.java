package com.like.system.user.port.out;

import java.util.List;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.port.in.SystemUserQueryDTO;

public interface SystemUserQueryDbPort {
	List<SystemUser> selectList(SystemUserQueryDTO dto);
}
