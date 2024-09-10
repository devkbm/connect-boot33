package com.like.cooperation.board.port.in.article;

import com.like.cooperation.board.port.in.article.dto.ArticleSaveMultipartDTO;

public interface ArticleSaveByMultiPartUseCase {	
	
	void save(ArticleSaveMultipartDTO dto);
		
}
