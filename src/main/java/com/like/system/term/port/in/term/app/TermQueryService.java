package com.like.system.term.port.in.term.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.term.TermQueryUseCase;
import com.like.system.term.port.in.term.dto.TermQueryDTO;
import com.like.system.term.port.in.term.dto.TermSaveDTO;
import com.like.system.term.port.in.term.dto.TermSaveDTOMapper;
import com.like.system.term.port.out.TermQueryDbPort;


@Transactional(readOnly = true)
@Service
public class TermQueryService implements TermQueryUseCase {

	TermQueryDbPort dbPort;

	public TermQueryService(TermQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public List<TermSaveDTO> select(TermQueryDTO dto) {
		return this.dbPort.select(dto)
						  .stream()
						  .map(e -> TermSaveDTOMapper.toDTO(e))
						  .toList();
	}
}
