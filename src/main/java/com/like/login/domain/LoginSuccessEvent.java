package com.like.login.domain;

import java.time.LocalDate;

public record LoginSuccessEvent(
		String companyCode,
		String userId,
		LocalDate loginDateTime,
		String clientIp
		) {
}
