package com.like.cooperation.todo.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.todo.adapter.out.db.jpa.TodoGroupJpaRepository;
import com.like.cooperation.todo.domain.QTodoGroup;
import com.like.cooperation.todo.domain.TodoGroup;
import com.like.cooperation.todo.port.in.TodoGroupQueryUseCase;

@Transactional(readOnly=true)
@Service
public class TodoGroupQueryService implements TodoGroupQueryUseCase {
	
	private TodoGroupJpaRepository repository;
	
	public TodoGroupQueryService(TodoGroupJpaRepository repository) {
		this.repository = repository;
	}			

	@Override
	public List<TodoGroup> select(String userId) {
		QTodoGroup qTodoGroup = QTodoGroup.todoGroup;
		
		//Iterable<TodoGroup> result = repository.findAll(qTodoGroup.createdBy.eq(userId)); 
		//List<TodoGroup> list = new ArrayList<>();
		//result.forEach(e -> list.add(e));
		
		return repository.findAll(qTodoGroup.userId.eq(userId));
	}
		
}
