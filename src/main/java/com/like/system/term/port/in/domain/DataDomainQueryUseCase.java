package com.like.system.term.port.in.domain;

import java.util.List;

import com.like.system.term.port.in.domain.dto.DataDomainSaveDTO;

public interface DataDomainQueryUseCase {
	List<DataDomainSaveDTO> selectList();
}
