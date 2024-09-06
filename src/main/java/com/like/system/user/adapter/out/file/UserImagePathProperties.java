package com.like.system.user.adapter.out.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user-image")
public record UserImagePathProperties(
		String uploadPath
		) {

}
