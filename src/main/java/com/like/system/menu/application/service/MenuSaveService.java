package com.like.system.menu.application.service;

import org.springframework.stereotype.Service;

import com.like.system.menu.application.port.in.MenuSaveUseCase;
import com.like.system.menu.application.port.out.MenuGroupSelectDbPort;
import com.like.system.menu.application.port.out.MenuSaveDbPort;
import com.like.system.menu.application.port.out.MenuSelectDbPort;
import com.like.system.menu.domain.Menu;
import com.like.system.menu.domain.MenuGroup;
import com.like.system.menu.dto.MenuSaveDTO;

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
		
		this.dbPort.save(dto.newMenu(menuGroup, parent));		
	}

}
