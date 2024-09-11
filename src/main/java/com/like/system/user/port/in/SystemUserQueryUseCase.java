package com.like.system.user.port.in;

import java.util.List;

import com.like.system.user.port.in.dto.SystemUserQueryDTO;
import com.like.system.user.port.in.dto.SystemUserSelectDTO;

public interface SystemUserQueryUseCase {
	List<SystemUserSelectDTO> selectList(SystemUserQueryDTO dto);
}
