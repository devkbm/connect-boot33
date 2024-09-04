package com.like.system.user.application.port.in;

import java.util.List;

public interface SystemUserQueryUseCase {
	List<SystemUserSelectDTO> selectList(SystemUserQueryDTO dto);
}
