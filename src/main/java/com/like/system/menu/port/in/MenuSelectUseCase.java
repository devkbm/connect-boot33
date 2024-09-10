package com.like.system.menu.port.in;

import java.util.List;

import com.like.system.menu.port.in.dto.MenuQueryDTO;
import com.like.system.menu.port.in.dto.MenuSaveDTO;

public interface MenuSelectUseCase {
	MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode);
	
	List<MenuSaveDTO> selectList(MenuQueryDTO dto);
}
