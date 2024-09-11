package com.like.system.term.port.in.term;

import java.util.List;

import com.like.system.term.port.in.term.dto.TermQueryDTO;
import com.like.system.term.port.in.term.dto.TermSaveDTO;

public interface TermQueryUseCase {
	List<TermSaveDTO> select(TermQueryDTO dto);
}
