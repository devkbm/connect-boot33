package com.like.system.menu_role.port.in.menu_role;

import java.util.List;

import com.like.system.menu_role.port.in.menu_role.dto.MenuRoleMappingSaveDTO;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
