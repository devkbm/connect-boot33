package com.like.system.term.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.term.adapter.out.db.jpa.WordDictionaryJpaRepository;
import com.like.system.term.domain.WordDictionary;
import com.like.system.term.port.out.WordQueryDbPort;

@Repository
public class WordQueryDbAdpater implements WordQueryDbPort {
	
	WordDictionaryJpaRepository repository;
	
	WordQueryDbAdpater(WordDictionaryJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<WordDictionary> select() {
		return this.repository.findAll();
	}

}
