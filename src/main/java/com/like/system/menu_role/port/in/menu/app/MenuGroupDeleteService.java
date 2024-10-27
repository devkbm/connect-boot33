package com.like.system.menu_role.port.in.menu.app;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.port.in.menu.MenuGroupDeleteUseCase;
import com.like.system.menu_role.port.out.menu.MenuGroupDeleteDbPort;

@Service
public class MenuGroupDeleteService implements MenuGroupDeleteUseCase {

	MenuGroupDeleteDbPort port;
	
	MenuGroupDeleteService(MenuGroupDeleteDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode) {
		this.port.delete(companyCode, menuGroupCode);
	}

}
