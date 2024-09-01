package com.like.system.user.adapter.out.persistence.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyId;

@Repository
public interface SystemUserCompanyRepository extends JpaRepository<SystemUserCompany, SystemUserCompanyId>, ListQuerydslPredicateExecutor<SystemUserCompany> {
}
