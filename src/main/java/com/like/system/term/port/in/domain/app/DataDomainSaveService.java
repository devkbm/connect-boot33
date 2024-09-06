package com.like.system.term.port.in.domain.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.domain.DataDomainSaveDTO;
import com.like.system.term.port.in.domain.DataDomainSaveUseCase;
import com.like.system.term.port.out.DataDomainCommandDbPort;

@Transactional
@Service
public class DataDomainSaveService implements DataDomainSaveUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainSaveService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(DataDomainSaveDTO dto) {
		this.dbPort.save(dto.newEntity());
	}

}
