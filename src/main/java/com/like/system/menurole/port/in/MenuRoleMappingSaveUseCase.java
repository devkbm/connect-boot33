package com.like.system.menurole.port.in;

import java.util.List;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
