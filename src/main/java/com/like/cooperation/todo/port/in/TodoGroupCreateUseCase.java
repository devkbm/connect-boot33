package com.like.cooperation.todo.port.in;

import com.like.cooperation.todo.domain.TodoGroup;

public interface TodoGroupCreateUseCase {

	TodoGroup create(String userId);
}
