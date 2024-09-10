package com.like.cooperation.todo.port.out;

import com.like.cooperation.todo.domain.TodoGroup;

public interface TodoGroupCommandDbPort {	
	
	TodoGroup select(Long id);
	
	void save(TodoGroup entity);
	
	void delete(Long id);
}
