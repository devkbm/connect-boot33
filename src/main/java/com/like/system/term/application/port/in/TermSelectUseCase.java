package com.like.system.term.application.port.in;

import com.like.system.term.dto.TermSaveDTO;

public interface TermSelectUseCase {
	TermSaveDTO select(String id);
}
