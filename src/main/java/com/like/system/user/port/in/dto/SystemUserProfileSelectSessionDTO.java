package com.like.system.user.port.in.dto;

import java.util.Date;

public record SystemUserProfileSelectSessionDTO(
		String ipAddress,
		Date lastAccessedTime) {

}
