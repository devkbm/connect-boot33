package com.like.system.company.port.in.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.like.system.company.domain.CompanyInfo;

@Mapper
public interface CompanyInfoSaveDTOMapstruct {
	
	CompanyInfoSaveDTOMapstruct INSTANCE = Mappers.getMapper( CompanyInfoSaveDTOMapstruct.class ); 

	@Mapping(target = "id", source = "companyCode")
	@Mapping(target = "appUrl", ignore = true)
	CompanyInfo toEntity(CompanyInfoSaveDTO dto);
	
	
	@Mapping(target = "companyCode", source = "id.companyCode")
	@Mapping(target = "clientAppUrl", ignore = true)
	CompanyInfoSaveDTO toDTO(CompanyInfo entity);
}
