package com.like.cooperation.board.port.in.article;

public interface ArticleUserHitCountUseCase {

	void plusHitCount(Long articleId, String userId);
}
