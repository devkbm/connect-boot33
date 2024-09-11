package com.like.system.term.port.in.word.dto;

import lombok.Builder;

@Builder
public record WordSaveDTO(
		String companyCode,
		String clientAppUrl,
		String logicalName,
		String logicalNameEng,
		String physicalName,
		String comment
		) {	
}