package com.like.system.term.port.in.domain;

import com.like.system.term.port.in.domain.dto.DataDomainSaveDTO;

public interface DataDomainSelectUseCase {
	DataDomainSaveDTO select(String id);
	
}
