package com.like.cooperation.todo.port.in;

import com.like.cooperation.todo.port.in.dto.TodoSaveDTO;

public interface TodoSaveUseCase {
	TodoSaveDTO save(TodoSaveDTO dto);
}
