package com.like.system.user.adapter.in.web;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.like.core.message.MessageUtil;
import com.like.system.user.application.port.in.SystemUserSaveUseCase;
import com.like.system.user.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.dto.SystemUserSaveByExcelDTOMapper;
import com.like.system.user.dto.SystemUserSaveDTO;

@RestController
public class SystemUserSaveController {		
					
	SystemUserSaveUseCase userCase;
		
	public SystemUserSaveController(SystemUserSaveUseCase userCase) {		
		this.userCase = userCase;
	}		
	
	@PostMapping("/api/system/user")	
	public ResponseEntity<?> saveUser(@Valid @RequestBody SystemUserSaveDTO dto) {			
											
		userCase.save(dto);					
																					 		
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
	
}