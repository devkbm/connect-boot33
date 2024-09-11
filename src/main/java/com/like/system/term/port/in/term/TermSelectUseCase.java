package com.like.system.term.port.in.term;

import com.like.system.term.port.in.term.dto.TermSaveDTO;

public interface TermSelectUseCase {
	TermSaveDTO select(String id);
}
