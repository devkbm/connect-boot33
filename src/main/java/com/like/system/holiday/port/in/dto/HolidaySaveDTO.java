package com.like.system.holiday.port.in.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record HolidaySaveDTO(
		String companyCode,
		String clientAppUrl,
		LocalDate date,
		String holidayName,			
		String comment
		) {		
}
