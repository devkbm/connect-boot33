package com.like.system.webresource.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.webresource.adapter.out.db.jpa.WebResourceJpaRepository;
import com.like.system.webresource.domain.WebResource;
import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.out.WebResourceQueryDbPort;

@Repository
@Transactional(readOnly = true)
public class WebResourceQueryDbAdapter implements WebResourceQueryDbPort {

	WebResourceJpaRepository repository;		
	
	public WebResourceQueryDbAdapter(WebResourceJpaRepository repository) {
		this.repository = repository;
	}	

	@Override
	public List<WebResource> getResourceList(WebResourceQueryDTO condition) {
		return this.repository.findAll(condition.getBooleanBuilder());
	}	

	
}
