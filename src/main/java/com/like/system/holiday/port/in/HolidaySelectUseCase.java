package com.like.system.holiday.port.in;

import java.time.LocalDate;

import com.like.system.holiday.port.in.dto.HolidaySaveDTO;

public interface HolidaySelectUseCase {
	HolidaySaveDTO select(String companyCode, LocalDate date);
}
