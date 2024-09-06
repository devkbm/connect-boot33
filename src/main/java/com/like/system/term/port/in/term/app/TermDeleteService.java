package com.like.system.term.port.in.term.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.term.TermDeleteUseCase;
import com.like.system.term.port.out.TermCommandDbPort;

@Transactional
@Service
public class TermDeleteService implements TermDeleteUseCase {
	
	TermCommandDbPort dbPort;
	
	TermDeleteService(TermCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String id) {
		this.dbPort.delete(id);
	}

}
