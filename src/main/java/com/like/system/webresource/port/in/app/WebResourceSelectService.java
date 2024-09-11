package com.like.system.webresource.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceSelectUseCase;
import com.like.system.webresource.port.in.dto.WebResourceSaveDTO;
import com.like.system.webresource.port.in.dto.WebResourceSaveDTOMapper;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceSelectService implements WebResourceSelectUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSelectService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public WebResourceSaveDTO select(String id) {
		return WebResourceSaveDTOMapper.toDTO(this.port.select(id));
	}

}
