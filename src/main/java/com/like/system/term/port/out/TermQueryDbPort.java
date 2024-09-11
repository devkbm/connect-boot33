package com.like.system.term.port.out;

import java.util.List;

import com.like.system.term.domain.TermDictionary;
import com.like.system.term.port.in.term.dto.TermQueryDTO;

public interface TermQueryDbPort {
	List<TermDictionary> select(TermQueryDTO dto);
}
