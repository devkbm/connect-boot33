package com.like.system.term.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.term.adapter.out.db.jpa.DataDomainDictionaryJpaRepository;
import com.like.system.term.domain.DataDomainDictionary;
import com.like.system.term.port.out.DataDomainQueryDbPort;

@Repository
public class DataDomainQueryDbAdapter implements DataDomainQueryDbPort {

	DataDomainDictionaryJpaRepository repository;
	
	DataDomainQueryDbAdapter(DataDomainDictionaryJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<DataDomainDictionary> select() {
		return this.repository.findAll();
	}

}
