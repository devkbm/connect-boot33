package com.like.system.webresource.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceDeleteUseCase;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceDeleteService implements WebResourceDeleteUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceDeleteService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String webResourceId) {
		this.port.delete(webResourceId);		
	}
	
}
