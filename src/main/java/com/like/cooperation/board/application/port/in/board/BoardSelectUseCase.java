package com.like.cooperation.board.application.port.in.board;

import com.like.cooperation.board.dto.BoardSaveDTO;

public interface BoardSelectUseCase {
	BoardSaveDTO select(Long boardId);
}
