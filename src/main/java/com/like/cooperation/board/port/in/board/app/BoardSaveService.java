package com.like.cooperation.board.port.in.board.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.port.in.board.BoardSaveUseCase;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTO;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTOMapper;
import com.like.cooperation.board.port.out.BoardCommandDbPort;

@Service
public class BoardSaveService implements BoardSaveUseCase {

	BoardCommandDbPort dbPort;
	
	BoardSaveService(BoardCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(BoardSaveDTO dto) {
		Board parentBoard = dto.boardParentId() == null ? null : this.dbPort.select(dto.boardParentId()).orElse(null);
		
		this.dbPort.save(BoardSaveDTOMapper.toEntity(dto, parentBoard));		
	}

}
