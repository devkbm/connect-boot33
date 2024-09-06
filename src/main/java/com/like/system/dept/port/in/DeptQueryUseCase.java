package com.like.system.dept.port.in;

import java.util.List;

public interface DeptQueryUseCase {
	List<DeptSaveDTO> select(DeptQueryDTO dto);
}
