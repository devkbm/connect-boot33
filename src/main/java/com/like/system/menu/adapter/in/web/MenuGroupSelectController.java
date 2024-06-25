package com.like.system.menu.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu.application.port.in.MenuGroupSelectUseCase;
import com.like.system.menu.dto.MenuGroupQueryDTO;
import com.like.system.menu.dto.MenuGroupSaveDTO;

@RestController
public class MenuGroupSelectController {
	
	private MenuGroupSelectUseCase useCase;		
			
	public MenuGroupSelectController(MenuGroupSelectUseCase useCase) {
		this.useCase = useCase;		
	}
			
	@GetMapping("/api/system/menugroup/{menuGroupCode}")
	public ResponseEntity<?> getMenuGroup(@RequestParam String companyCode, @PathVariable String menuGroupCode) {				
		
		MenuGroupSaveDTO dto = useCase.select(companyCode, menuGroupCode);				
								
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}				
	
	@GetMapping("/api/system/menugroup")
	public ResponseEntity<?> getMenuGroupList(MenuGroupQueryDTO dto) {				
		
		List<MenuGroupSaveDTO> dtoList = useCase.selectList(dto); 																								 
		
		return toList(dtoList, MessageUtil.getQueryMessage(dtoList.size()));
	}
	
}
