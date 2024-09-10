package com.like.cooperation.board.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;

import com.like.cooperation.board.domain.Article;

public interface ArticleJpaRepository extends JpaRepository<Article, Long>, ListQuerydslPredicateExecutor<Article> {
	
}
