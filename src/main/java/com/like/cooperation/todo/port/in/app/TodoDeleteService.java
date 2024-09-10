package com.like.cooperation.todo.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.domain.TodoGroup;
import com.like.cooperation.todo.port.in.TodoDeleteUseCase;
import com.like.cooperation.todo.port.out.TodoGroupCommandDbPort;

@Transactional
@Service
public class TodoDeleteService implements TodoDeleteUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoDeleteService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public void delete(Long todoGroupId, Long todoId) {
		TodoGroup todoGroup = dbPort.select(todoGroupId);	
		todoGroup.removeTodo(todoId);
		dbPort.save(todoGroup);
	}
}
