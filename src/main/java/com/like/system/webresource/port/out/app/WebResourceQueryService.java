package com.like.system.webresource.port.out.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceQueryDTO;
import com.like.system.webresource.port.in.WebResourceQueryUseCase;
import com.like.system.webresource.port.in.WebResourceSaveDTO;
import com.like.system.webresource.port.out.WebResourceQueryDbPort;

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