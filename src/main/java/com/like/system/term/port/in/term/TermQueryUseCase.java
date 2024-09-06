package com.like.system.term.port.in.term;

import java.util.List;

public interface TermQueryUseCase {
	List<TermSaveDTO> select(TermQueryDTO dto);
}
