package com.like.system.term.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.system.term.adapter.out.db.jpa.TermDictionaryJpaRepository;
import com.like.system.term.domain.TermDictionary;
import com.like.system.term.port.out.TermCommandDbPort;

@Repository
public class TermDbAdapter implements TermCommandDbPort {

	TermDictionaryJpaRepository repository;
	
	TermDbAdapter(TermDictionaryJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public TermDictionary select(String id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void save(TermDictionary entity) {
		this.repository.save(entity);
		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);		
	}
}
