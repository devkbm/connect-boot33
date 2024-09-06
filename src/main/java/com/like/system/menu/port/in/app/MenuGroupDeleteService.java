package com.like.system.menu.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.menu.port.in.MenuGroupDeleteUseCase;
import com.like.system.menu.port.out.MenuGroupDeleteDbPort;

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
