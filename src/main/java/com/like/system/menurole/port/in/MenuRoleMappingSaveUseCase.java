package com.like.system.menurole.port.in;

import java.util.List;

import com.like.system.menurole.port.in.dto.MenuRoleMappingSaveDTO;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
