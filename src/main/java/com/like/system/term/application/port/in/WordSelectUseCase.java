package com.like.system.term.application.port.in;

import com.like.system.term.dto.WordSaveDTO;

public interface WordSelectUseCase {
	WordSaveDTO select(String id);
}
