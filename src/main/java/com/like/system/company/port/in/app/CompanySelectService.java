package com.like.system.company.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;
import com.like.system.company.port.in.CompanySelectUseCase;
import com.like.system.company.port.in.dto.CompanyInfoSaveDTO;
import com.like.system.company.port.in.dto.CompanyInfoSaveDTOMapper;
import com.like.system.company.port.in.dto.CompanyInfoSaveDTOMapstruct;
import com.like.system.company.port.out.CompanyCommandDbPort;

@Transactional
@Service
public class CompanySelectService implements CompanySelectUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanySelectService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public CompanyInfoSaveDTO select(String companyCode) {
		CompanyInfo entity = this.dbPort.select(new CompanyInfoId(companyCode)).orElse(null);
		
		//return entity == null ? null : CompanyInfoSaveDTOMapper.toDTO(entity);
		return entity == null ? null : CompanyInfoSaveDTOMapstruct.INSTANCE.toDTO(entity);
	}

}
