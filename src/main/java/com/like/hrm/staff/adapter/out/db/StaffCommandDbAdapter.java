package com.like.hrm.staff.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.jpa.StaffJpaRepository;
import com.like.hrm.staff.domain.model.Staff;
import com.like.hrm.staff.domain.model.StaffId;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

@Repository
public class StaffCommandDbAdapter implements StaffCommandDbPort {

	StaffJpaRepository repository;
	
	StaffCommandDbAdapter(StaffJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Staff> select(String companyCode, String staffNo) {
		return this.repository.findById(new StaffId(companyCode, staffNo));
	}

	@Override
	public void save(Staff entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String companyCode, String staffNo) {
		this.repository.deleteById(new StaffId(companyCode, staffNo));	
	}

}