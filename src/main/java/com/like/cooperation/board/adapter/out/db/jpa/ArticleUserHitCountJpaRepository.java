package com.like.cooperation.board.adapter.out.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.cooperation.board.domain.ArticleUserHitCount;
import com.like.cooperation.board.domain.ArticleUserHitCountId;

public interface ArticleUserHitCountJpaRepository extends JpaRepository<ArticleUserHitCount, ArticleUserHitCountId> {	
}
