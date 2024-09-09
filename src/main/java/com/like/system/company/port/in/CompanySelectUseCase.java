package com.like.system.company.port.in;

import com.like.system.company.port.in.dto.CompanyInfoSaveDTO;

public interface CompanySelectUseCase {
	CompanyInfoSaveDTO select(String companyCode);
}
