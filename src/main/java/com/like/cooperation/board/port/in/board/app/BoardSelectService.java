package com.like.cooperation.board.port.in.board.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.port.in.board.BoardSelectUseCase;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTO;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTOMapper;
import com.like.cooperation.board.port.out.BoardCommandDbPort;

@Service
public class BoardSelectService implements BoardSelectUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSelectService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public BoardSaveDTO select(Long boardId) {
		return BoardSaveDTOMapper.toDTO(this.dbPort.select(boardId).orElse(null));
	}

}
