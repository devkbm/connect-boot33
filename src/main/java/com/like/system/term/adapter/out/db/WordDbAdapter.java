package com.like.system.term.adapter.out.db;

import org.springframework.stereotype.Repository;

import com.like.system.term.adapter.out.db.jpa.WordDictionaryJpaRepository;
import com.like.system.term.domain.WordDictionary;
import com.like.system.term.port.out.WordCommandDbPort;

@Repository
public class WordDbAdapter implements WordCommandDbPort {

	WordDictionaryJpaRepository repository;
	
	WordDbAdapter(WordDictionaryJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public WordDictionary select(String id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public void save(WordDictionary entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);		
	}

}
