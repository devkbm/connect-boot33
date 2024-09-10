package com.like.cooperation.board.port.in.board.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.port.in.board.BoardQueryUseCase;
import com.like.cooperation.board.port.in.board.dto.BoardHierarchy;
import com.like.cooperation.board.port.in.board.dto.BoardQueryDTO;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTO;
import com.like.cooperation.board.port.out.BoardQueryDbPort;

@Transactional(readOnly=true)
@Service
public class BoardQueryService implements BoardQueryUseCase {

	BoardQueryDbPort port;
	
	BoardQueryService(BoardQueryDbPort port) {
		this.port = port;
	}	
	
	@Override
	public List<BoardSaveDTO> selectList(BoardQueryDTO dto) {
		return this.port.selectList(dto);
	}

	@Override
	public List<BoardHierarchy> selectHierarchy() {
		return this.port.selectHierarchy();
	}

}
