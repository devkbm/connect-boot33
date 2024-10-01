package com.like.system.menu.port.in.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record MenuSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,						
		String companyCode,
		@NotEmpty
		String menuGroupCode,
		String menuCode,			
		@NotEmpty
		String menuName,
		String appUrl,
		String parentMenuCode,
		String menuType,
		long sequence,
		long level
		) {		
	
}