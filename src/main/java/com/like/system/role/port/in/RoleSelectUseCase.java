package com.like.system.role.port.in;

import com.like.system.role.domain.Role;

public interface RoleSelectUseCase {
	Role select(String companyCode, String roleCode);
}
