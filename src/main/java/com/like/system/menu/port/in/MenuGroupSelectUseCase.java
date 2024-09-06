package com.like.system.menu.port.in;

import java.util.List;

public interface MenuGroupSelectUseCase {
	MenuGroupSaveDTO select(String companyCode, String menuGroupCode);
	
	List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto);
}
