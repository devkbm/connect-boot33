package com.like.system.dept.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.dept.adapter.out.db.jpa.DeptJpaRepository;
import com.like.system.dept.domain.Dept;
import com.like.system.dept.port.in.dto.DeptQueryDTO;
import com.like.system.dept.port.out.DeptQueryDbPort;

@Repository
public class DeptQueryDbAdapter implements DeptQueryDbPort {

	DeptJpaRepository repository;
	
	public DeptQueryDbAdapter(DeptJpaRepository repository) {
		this.repository = repository;
	}	
	
	@Override
	public List<Dept> select(DeptQueryDTO dto) {
		return this.repository.findAll(dto.getCondition());
	}
	
}
