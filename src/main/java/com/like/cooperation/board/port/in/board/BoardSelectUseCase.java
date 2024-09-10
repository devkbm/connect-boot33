package com.like.cooperation.board.port.in.board;

import com.like.cooperation.board.port.in.board.dto.BoardSaveDTO;

public interface BoardSelectUseCase {
	BoardSaveDTO select(Long boardId);
}
