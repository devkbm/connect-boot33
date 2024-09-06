package com.like.system.term.port.in.word.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.word.WordDeleteUseCase;
import com.like.system.term.port.out.WordCommandDbPort;

@Transactional
@Service
public class WordDeleteService implements WordDeleteUseCase {

	WordCommandDbPort dbPort;
	
	WordDeleteService(WordCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String id) {
		this.dbPort.delete(id);
	}

}
