package com.like.system.menu_role.port.in.menu.app;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.port.in.menu.MenuGroupSaveUseCase;
import com.like.system.menu_role.port.in.menu.dto.MenuGroupSaveDTO;
import com.like.system.menu_role.port.in.menu.dto.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.port.out.menu.MenuGroupSaveDbPort;

@Service
public class MenuGroupSaveService implements MenuGroupSaveUseCase {

	MenuGroupSaveDbPort port;
	
	MenuGroupSaveService(MenuGroupSaveDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(MenuGroupSaveDTO dto) {
		this.port.save(MenuGroupSaveDTOMapper.newMenuGroup(dto));		
	}

}
