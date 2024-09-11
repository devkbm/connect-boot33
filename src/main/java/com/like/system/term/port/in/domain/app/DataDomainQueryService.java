package com.like.system.term.port.in.domain.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.term.port.in.domain.DataDomainQueryUseCase;
import com.like.system.term.port.in.domain.dto.DataDomainSaveDTO;
import com.like.system.term.port.in.domain.dto.DataDomainSaveDTOMapper;
import com.like.system.term.port.out.DataDomainQueryDbPort;

@Service
public class DataDomainQueryService implements DataDomainQueryUseCase {

	DataDomainQueryDbPort dbPort;
	
	DataDomainQueryService(DataDomainQueryDbPort dbPort) {
		this.dbPort = dbPort;				
	}
	
	@Override
	public List<DataDomainSaveDTO> selectList() {
		return this.dbPort.select()
						  .stream()
						  .map(e -> DataDomainSaveDTOMapper.toDTO(e))
						  .toList();
	}

}
