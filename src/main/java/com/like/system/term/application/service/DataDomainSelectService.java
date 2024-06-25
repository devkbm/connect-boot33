package com.like.system.term.application.service;

import org.springframework.stereotype.Service;

import com.like.system.term.application.port.in.DataDomainSelectUseCase;
import com.like.system.term.application.port.out.DataDomainCommandDbPort;
import com.like.system.term.dto.DataDomainSaveDTO;

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
