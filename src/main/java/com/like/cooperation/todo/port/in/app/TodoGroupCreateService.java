package com.like.cooperation.todo.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.domain.TodoGroup;
import com.like.cooperation.todo.port.in.TodoGroupCreateUseCase;
import com.like.cooperation.todo.port.out.TodoGroupCommandDbPort;

@Transactional
@Service
public class TodoGroupCreateService implements TodoGroupCreateUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoGroupCreateService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TodoGroup create(String userId) {
		TodoGroup taskGroup = new TodoGroup(userId);
		dbPort.save(taskGroup);
		
		return taskGroup;
	}

}
