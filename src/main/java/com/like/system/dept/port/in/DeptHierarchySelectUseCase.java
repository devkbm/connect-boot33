package com.like.system.dept.port.in;

import java.util.List;

public interface DeptHierarchySelectUseCase {
	List<?> select(DeptQueryDTO dto);
}
