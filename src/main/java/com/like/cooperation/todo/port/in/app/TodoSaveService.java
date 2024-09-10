package com.like.cooperation.todo.port.in.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.domain.Todo;
import com.like.cooperation.todo.domain.TodoGroup;
import com.like.cooperation.todo.port.in.TodoSaveUseCase;
import com.like.cooperation.todo.port.in.dto.TodoSaveDTO;
import com.like.cooperation.todo.port.out.TodoGroupCommandDbPort;

@Transactional
@Service
public class TodoSaveService implements TodoSaveUseCase {

	TodoGroupCommandDbPort dbPort;
	
	TodoSaveService(TodoGroupCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TodoSaveDTO save(TodoSaveDTO dto) {
		
		TodoGroup todoGroup = dbPort.select(dto.pkTodoGroup());
		Todo entity = null;
		
		if (dto.pkTodo() == null) {			
			todoGroup.addTodo(dto.newEntity(todoGroup));
		} else {
			entity = todoGroup.getTodo(dto.pkTodo());
			dto.modifyEntity(entity);
		}
					
		dbPort.save(todoGroup);			
		
		return TodoSaveDTO.toDTO(todoGroup.getLastTodo());
		
	}

}
