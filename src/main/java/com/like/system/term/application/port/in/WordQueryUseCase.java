package com.like.system.term.application.port.in;

import java.util.List;

import com.like.system.term.dto.WordSaveDTO;

public interface WordQueryUseCase {
	List<WordSaveDTO> select();
}
