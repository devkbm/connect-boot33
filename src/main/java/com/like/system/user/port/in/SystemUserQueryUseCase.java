package com.like.system.user.port.in;

import java.util.List;

public interface SystemUserQueryUseCase {
	List<SystemUserSelectDTO> selectList(SystemUserQueryDTO dto);
}
