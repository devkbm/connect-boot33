package com.like.system.menu.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.menu.port.in.MenuGroupSaveUseCase;
import com.like.system.menu.port.in.dto.MenuGroupSaveDTO;
import com.like.system.menu.port.in.dto.MenuGroupSaveDTOMapper;
import com.like.system.menu.port.out.MenuGroupSaveDbPort;

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
