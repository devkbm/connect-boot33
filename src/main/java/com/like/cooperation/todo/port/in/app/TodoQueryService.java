package com.like.cooperation.todo.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.adapter.out.db.jpa.TodoJpaRepository;
import com.like.cooperation.todo.domain.QTodo;
import com.like.cooperation.todo.port.in.TodoQueryUseCase;
import com.like.cooperation.todo.port.in.dto.TodoSaveDTO;

@Transactional(readOnly=true)
@Service
public class TodoQueryService implements TodoQueryUseCase {

	TodoJpaRepository repository;
	
	TodoQueryService(TodoJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<TodoSaveDTO> select(Long todoGroupId) {
		QTodo qTodo = QTodo.todo1;
				
		return this.repository.findAll(qTodo.todoGroup.pkTodoGroup.eq(todoGroupId))
							  .stream()
							  .map(e -> TodoSaveDTO.toDTO(e))
							  .toList();
	}

	
}
