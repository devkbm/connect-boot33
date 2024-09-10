package com.like.system.menu.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu.adapter.out.db.jpa.MenuGroupJpaRepository;
import com.like.system.menu.adapter.out.db.jpa.MenuJpaRepository;
import com.like.system.menu.domain.Menu;
import com.like.system.menu.domain.MenuId;
import com.like.system.menu.port.in.dto.MenuQueryDTO;
import com.like.system.menu.port.out.MenuDeleteDbPort;
import com.like.system.menu.port.out.MenuSaveDbPort;
import com.like.system.menu.port.out.MenuSelectDbPort;

@Repository
public class MenuDbAdapter implements MenuSelectDbPort, MenuSaveDbPort, MenuDeleteDbPort {
	MenuJpaRepository repository;
	MenuGroupJpaRepository menuGroupRepository;
	
	MenuDbAdapter(MenuJpaRepository repository
				 ,MenuGroupJpaRepository menuGroupRepository) {
		this.repository = repository;
		this.menuGroupRepository = menuGroupRepository;
	}

	@Override
	public Menu select(String companyCode, String menuGroupCode, String menuCode) {		
						
		return this.repository.findById(new MenuId(companyCode, menuGroupCode, menuCode)).orElse(null);
	}

	@Override
	public List<Menu> selectList(MenuQueryDTO dto) {
		
		return this.repository.findAll(dto.getBooleanBuilder());							  
	}
	
	@Override
	public void save(Menu entity) {		
		this.repository.save(entity);
	}

	@Override
	public void delete(String companyCode, String menuGroupCode, String menuCode) {
		this.repository.deleteById(new MenuId(companyCode, menuGroupCode, menuCode));		
	}
	
}
