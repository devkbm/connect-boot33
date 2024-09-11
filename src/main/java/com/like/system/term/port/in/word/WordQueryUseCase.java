package com.like.system.term.port.in.word;

import java.util.List;

import com.like.system.term.port.in.word.dto.WordSaveDTO;

public interface WordQueryUseCase {
	List<WordSaveDTO> select();
}
