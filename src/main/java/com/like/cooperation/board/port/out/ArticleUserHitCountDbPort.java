package com.like.cooperation.board.port.out;

import com.like.cooperation.board.domain.Article;

public interface ArticleUserHitCountDbPort {
	void plusHitCount(Article article, String userId);
}
