package com.like.system.dept.port.in;

import java.util.List;

import com.like.system.dept.port.in.dto.DeptQueryDTO;

public interface DeptHierarchySelectUseCase {
	List<?> select(DeptQueryDTO dto);
}
