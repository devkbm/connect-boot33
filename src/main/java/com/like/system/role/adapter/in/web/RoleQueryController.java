package com.like.system.role.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.role.adapter.out.persistence.db.jpa.JpaRole;
import com.like.system.role.port.in.RoleQueryDTO;
import com.like.system.role.port.in.RoleQueryUseCase;

@RestController
public class RoleQueryController {

	private RoleQueryUseCase service;
	
	public RoleQueryController(RoleQueryUseCase service) {
		this.service = service;				
	}
	
	@GetMapping("/api/system/role")
	public ResponseEntity<?> getAuthorityList(RoleQueryDTO dto) {				
		
		List<JpaRole> authorityList = service.getAuthorityList(dto);								 							
		
		return toList(authorityList, MessageUtil.getQueryMessage(authorityList.size()));
	}
}
