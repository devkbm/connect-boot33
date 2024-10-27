package com.like.system.menu_role.port.in.menu.app;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.port.in.menu.MenuSaveUseCase;
import com.like.system.menu_role.port.in.menu.dto.MenuSaveDTO;
import com.like.system.menu_role.port.in.menu.dto.MenuSaveDTOMapper;
import com.like.system.menu_role.port.out.menu.MenuGroupSelectDbPort;
import com.like.system.menu_role.port.out.menu.MenuSaveDbPort;
import com.like.system.menu_role.port.out.menu.MenuSelectDbPort;

@Service
public class MenuSaveService implements MenuSaveUseCase {

	MenuSaveDbPort dbPort;
	MenuGroupSelectDbPort menuGroupDbPort;
	MenuSelectDbPort menuSelectDbPort;	
	
	MenuSaveService(MenuSaveDbPort dbPort,
				    MenuGroupSelectDbPort menuGroupDbPort,
				    MenuSelectDbPort menuSelectDbPort) {
		this.dbPort = dbPort;
		this.menuGroupDbPort = menuGroupDbPort;
		this.menuSelectDbPort = menuSelectDbPort;
	}
	
	@Override
	public void save(MenuSaveDTO dto) {
		MenuGroup menuGroup = this.menuGroupDbPort.select(dto.companyCode(), dto.menuGroupCode());
		Menu parent =  this.menuSelectDbPort.select(dto.companyCode(), dto.menuGroupCode(), dto.parentMenuCode());
		
		this.dbPort.save(MenuSaveDTOMapper.toEntity(dto, menuGroup, parent));		
	}

}
