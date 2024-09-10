package com.like.system.menu.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu.port.in.MenuGroupSelectUseCase;
import com.like.system.menu.port.in.dto.MenuGroupQueryDTO;
import com.like.system.menu.port.in.dto.MenuGroupSaveDTO;
import com.like.system.menu.port.out.MenuGroupSelectDbPort;

@Service
public class MenuGroupSelectService implements MenuGroupSelectUseCase {

	MenuGroupSelectDbPort port;
	
	MenuGroupSelectService(MenuGroupSelectDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuGroupSaveDTO select(String companyCode, String menuGroupCode) {
		return MenuGroupSaveDTO.toDTO(this.port.select(companyCode, menuGroupCode));
	}

	@Override
	public List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto) {
		return this.port.selectList(dto)
						.stream()
						.map(e -> MenuGroupSaveDTO.toDTO(e))
						.toList();
	}

}
