package com.like.login.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.like.login.domain.LogInOutHistory;

@Repository
public interface LogInOutHistoryRepository extends JpaRepository<LogInOutHistory, Long> {

}
