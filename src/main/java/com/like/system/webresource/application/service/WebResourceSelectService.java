package com.like.system.webresource.application.service;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.WebResourceSelectUseCase;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;
import com.like.system.webresource.dto.WebResourceSaveDTO;

@Service
public class WebResourceSelectService implements WebResourceSelectUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSelectService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public WebResourceSaveDTO select(String id) {
		return WebResourceSaveDTO.toDTO(this.port.select(id));
	}

}
