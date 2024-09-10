package com.like.cooperation.todo.port.in;

import java.util.List;

import com.like.cooperation.todo.port.in.dto.TodoSaveDTO;

public interface TodoQueryUseCase {

	List<TodoSaveDTO> select(Long todoGroupId);
}
