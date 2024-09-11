package com.like.system.term.port.in.term.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.term.TermSelectUseCase;
import com.like.system.term.port.in.term.dto.TermSaveDTO;
import com.like.system.term.port.in.term.dto.TermSaveDTOMapper;
import com.like.system.term.port.out.TermCommandDbPort;

@Transactional
@Service
public class TermSelectService implements TermSelectUseCase {

	TermCommandDbPort dbPort;
	
	TermSelectService(TermCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TermSaveDTO select(String id) {
		return TermSaveDTOMapper.toDTO(this.dbPort.select(id));
	}

}
