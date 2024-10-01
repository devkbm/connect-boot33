package com.like.system.webresource.port.in.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record WebResourceSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		@NotEmpty
		String resourceId,
		@NotEmpty
		String resourceName,
		String resourceType,
		@NotEmpty
		String url,
		String description
		) {
}