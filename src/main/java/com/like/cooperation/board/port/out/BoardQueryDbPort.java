package com.like.cooperation.board.port.out;

import java.util.List;

import com.like.cooperation.board.port.in.board.dto.BoardHierarchy;
import com.like.cooperation.board.port.in.board.dto.BoardQueryDTO;
import com.like.cooperation.board.port.in.board.dto.BoardSaveDTO;

public interface BoardQueryDbPort {
	
	List<BoardSaveDTO> selectList(BoardQueryDTO dto);
	
	List<BoardHierarchy> selectHierarchy();
}
