package com.like.system.company.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.adapter.out.db.jpa.CompanyJpaRepository;
import com.like.system.company.port.in.CompanyQueryUseCase;
import com.like.system.company.port.in.dto.CompanyInfoSaveDTO;
import com.like.system.company.port.in.dto.CompanyInfoSaveDTOMapstruct;

@Transactional(readOnly = true)
@Service
public class CompanyQueryService implements CompanyQueryUseCase {

	CompanyJpaRepository dbPort;
	
	CompanyQueryService(CompanyJpaRepository dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<CompanyInfoSaveDTO> query() {
		
		return this.dbPort.findAll()
						  .stream()
						  .map(e -> CompanyInfoSaveDTOMapstruct.INSTANCE.toDTO(e))
						  .toList();
	}

}
