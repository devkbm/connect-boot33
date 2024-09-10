package com.like.hrm.staff.port.out;

import java.util.Optional;

import com.like.hrm.staff.domain.Staff;

public interface StaffCommandDbPort {

	Optional<Staff> select(String companyCode, String staffNo);
	
	void save(Staff entity);
	
	void delete(String companyCode, String staffNo);
}
