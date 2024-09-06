package com.like.system.user.port.in;

import java.util.Date;

public record SystemUserProfileSelectSessionDTO(
		String ipAddress,
		Date lastAccessedTime) {

}
