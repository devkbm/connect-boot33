package com.like.system.company.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

public interface CompanyJpaRepository extends JpaRepository<CompanyInfo, CompanyInfoId>, ListQuerydslPredicateExecutor<CompanyInfo> {
				
}