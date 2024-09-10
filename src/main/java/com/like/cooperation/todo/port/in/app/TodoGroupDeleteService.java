package com.like.cooperation.todo.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.port.in.TodoGroupDeleteUseCase;
import com.like.cooperation.todo.port.out.TodoGroupCommandDbPort;

@Transactional
@Service
public class TodoGroupDeleteService implements TodoGroupDeleteUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoGroupDeleteService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}

}
