package com.like.system.dept.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.dept.adapter.out.db.jpa.DeptJpaRepository;
import com.like.system.dept.domain.Dept;
import com.like.system.dept.domain.DeptId;
import com.like.system.dept.port.out.DeptCommandDbPort;

@Repository
public class DeptCommandDbAdapter implements DeptCommandDbPort {

	DeptJpaRepository repository;
	
	public DeptCommandDbAdapter(DeptJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Optional<Dept> select(String companyCode, String deptCode) {		
		return this.repository.findById(new DeptId(companyCode, deptCode));
	}
	
	@Override
	public void save(Dept entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String companyCode, String deptCode) {
		this.repository.deleteById(new DeptId(companyCode, deptCode));		
	}

	
}
