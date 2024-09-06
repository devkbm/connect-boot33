package com.like.system.holiday.port.in;

import java.time.LocalDate;

public interface HolidaySelectUseCase {
	HolidaySaveDTO select(String companyCode, LocalDate date);
}
