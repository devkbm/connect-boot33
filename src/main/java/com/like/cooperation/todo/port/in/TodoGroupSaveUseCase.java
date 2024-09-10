package com.like.cooperation.todo.port.in;

import com.like.cooperation.todo.port.in.dto.TodoGroupSaveDTO;

public interface TodoGroupSaveUseCase {
	void save(TodoGroupSaveDTO dto);
}
