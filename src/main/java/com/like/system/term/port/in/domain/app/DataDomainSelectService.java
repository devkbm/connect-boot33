package com.like.system.term.port.in.domain.app;

import org.springframework.stereotype.Service;

import com.like.system.term.port.in.domain.DataDomainSaveDTO;
import com.like.system.term.port.in.domain.DataDomainSelectUseCase;
import com.like.system.term.port.out.DataDomainCommandDbPort;

@Service
public class DataDomainSelectService implements DataDomainSelectUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainSelectService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public DataDomainSaveDTO select(String id) {
		return DataDomainSaveDTO.toDTO(this.dbPort.select(id));
	}
}
