package com.like.system.webresource.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceSaveUseCase;
import com.like.system.webresource.port.in.dto.WebResourceSaveDTO;
import com.like.system.webresource.port.in.dto.WebResourceSaveDTOMapper;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceSaveService implements WebResourceSaveUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSaveService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(WebResourceSaveDTO dto) {
		this.port.save(WebResourceSaveDTOMapper.toEntity(dto));		
	}
}
