package com.like.system.company.port.in;

import com.like.system.company.port.in.dto.CompanyInfoSaveDTO;

import jakarta.annotation.Nullable;

public interface CompanySelectUseCase {
	@Nullable CompanyInfoSaveDTO select(String companyCode);
}
