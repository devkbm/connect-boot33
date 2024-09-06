package com.like.system.webresource.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.system.webresource.adapter.out.db.jpa.WebResourceJpaRepository;
import com.like.system.webresource.domain.WebResource;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Repository
public class WebResourceDbAdapter implements WebResourceCommandDbPort {

	WebResourceJpaRepository repository;
	
	WebResourceDbAdapter(WebResourceJpaRepository repository) {
		this.repository = repository;
	}
	 
	@Override
	public WebResource select(String id) {		
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void save(WebResource entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}
	
}
