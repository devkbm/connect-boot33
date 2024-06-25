package com.like.system.webresource.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.WebResourceQueryUseCase;
import com.like.system.webresource.application.port.out.WebResourceQueryDbPort;
import com.like.system.webresource.dto.WebResourceQueryDTO;
import com.like.system.webresource.dto.WebResourceSaveDTO;

@Service
public class WebResourceQueryService implements WebResourceQueryUseCase {

	private WebResourceQueryDbPort port;
	
	public WebResourceQueryService(WebResourceQueryDbPort port) {
		this.port = port;		
	}	

	@Override
	public List<WebResourceSaveDTO> getResourceList(WebResourceQueryDTO dto) {	
		return this.port.getResourceList(dto)
						.stream()
						.map(e -> WebResourceSaveDTO.toDTO(e))
						.toList();
	}
}
