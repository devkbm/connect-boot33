package com.like.cooperation.board.port.in.board.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.port.in.board.BoardDeleteUseCase;
import com.like.cooperation.board.port.out.BoardCommandDbPort;

@Service
public class BoardDeleteService implements BoardDeleteUseCase {

	BoardCommandDbPort dbPort;
	
	BoardDeleteService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}

}
