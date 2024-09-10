package com.like.cooperation.board.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.jpa.BoardJpaRepository;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.port.out.BoardCommandDbPort;

@Repository
public class BoardDbAdapter implements BoardCommandDbPort {

	BoardJpaRepository repository;
	
	BoardDbAdapter(BoardJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Board> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(Board entity) {				
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long boardId) {
		this.repository.deleteById(boardId);		
	}

}
