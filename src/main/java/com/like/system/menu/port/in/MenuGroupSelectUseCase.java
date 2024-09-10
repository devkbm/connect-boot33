package com.like.system.menu.port.in;

import java.util.List;

import com.like.system.menu.port.in.dto.MenuGroupQueryDTO;
import com.like.system.menu.port.in.dto.MenuGroupSaveDTO;

public interface MenuGroupSelectUseCase {
	MenuGroupSaveDTO select(String companyCode, String menuGroupCode);
	
	List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto);
}
