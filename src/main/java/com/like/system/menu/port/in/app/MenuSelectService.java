package com.like.system.menu.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu.port.in.MenuQueryDTO;
import com.like.system.menu.port.in.MenuSaveDTO;
import com.like.system.menu.port.in.MenuSelectUseCase;
import com.like.system.menu.port.out.MenuSelectDbPort;

@Service
public class MenuSelectService implements MenuSelectUseCase {

	MenuSelectDbPort port;
	
	MenuSelectService(MenuSelectDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode) {
		return MenuSaveDTO.toDTO(this.port.select(companyCode, menuGroupCode, menuCode));
	}

	@Override
	public List<MenuSaveDTO> selectList(MenuQueryDTO dto) {
		return this.port.selectList(dto)
						.stream()
						.map(e -> MenuSaveDTO.toDTO(e))
						.toList();
	}

}
