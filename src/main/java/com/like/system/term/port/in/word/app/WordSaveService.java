package com.like.system.term.port.in.word.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.word.WordSaveDTO;
import com.like.system.term.port.in.word.WordSaveUseCase;
import com.like.system.term.port.out.WordCommandDbPort;

@Transactional
@Service
public class WordSaveService implements WordSaveUseCase {

	WordCommandDbPort dbPort;
	
	WordSaveService(WordCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	@Override
	public void save(WordSaveDTO dto) {
		this.dbPort.save(dto.newEntity());
	}

}
