package com.like.cooperation.todo.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.domain.TodoGroup;
import com.like.cooperation.todo.port.in.TodoGroupSaveUseCase;
import com.like.cooperation.todo.port.in.dto.TodoGroupSaveDTO;
import com.like.cooperation.todo.port.out.TodoGroupCommandDbPort;

@Transactional
@Service
public class TodoGroupSaveService implements TodoGroupSaveUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoGroupSaveService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(TodoGroupSaveDTO dto) {
		TodoGroup entity = dbPort.select(dto.pkTodoGroup());
		
		entity.modify(dto.todoGroupName());
		
		dbPort.save(entity);
	}

}
