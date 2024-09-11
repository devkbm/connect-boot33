package com.like.system.term.port.in.word;

import com.like.system.term.port.in.word.dto.WordSaveDTO;

public interface WordSelectUseCase {
	WordSaveDTO select(String id);
}
