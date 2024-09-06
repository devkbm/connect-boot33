package com.like.system.menu.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.menu.port.in.MenuDeleteUseCase;
import com.like.system.menu.port.out.MenuDeleteDbPort;

@Service
public class MenuDeleteService implements MenuDeleteUseCase {

	MenuDeleteDbPort port;
	
	MenuDeleteService(MenuDeleteDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode, String menuCode) {
		this.port.delete(companyCode, menuGroupCode, menuCode);		
	}

}
