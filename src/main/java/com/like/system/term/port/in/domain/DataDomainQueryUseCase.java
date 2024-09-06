package com.like.system.term.port.in.domain;

import java.util.List;

public interface DataDomainQueryUseCase {
	List<DataDomainSaveDTO> selectList();
}
