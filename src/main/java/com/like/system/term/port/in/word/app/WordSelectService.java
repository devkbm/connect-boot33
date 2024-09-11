package com.like.system.term.port.in.word.app;

import org.springframework.stereotype.Service;

import com.like.system.term.port.in.word.WordSelectUseCase;
import com.like.system.term.port.in.word.dto.WordSaveDTO;
import com.like.system.term.port.in.word.dto.WordSaveDTOMapper;
import com.like.system.term.port.out.WordCommandDbPort;

@Service
public class WordSelectService implements WordSelectUseCase {

	WordCommandDbPort dbPort;
	
	WordSelectService(WordCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public WordSaveDTO select(String id) {
		return WordSaveDTOMapper.toDTO(this.dbPort.select(id));
	}

}
