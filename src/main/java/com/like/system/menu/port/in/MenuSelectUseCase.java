package com.like.system.menu.port.in;

import java.util.List;

public interface MenuSelectUseCase {
	MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode);
	
	List<MenuSaveDTO> selectList(MenuQueryDTO dto);
}
