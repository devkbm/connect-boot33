package com.like.cooperation.board.port.in.article;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.port.in.article.dto.ArticleListDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;

public interface ArticleQueryBySliceUseCase {
	
	Slice<ArticleListDTO> getAritlceSlice(String userId, ArticleQueryDTO dto, Pageable pageable);
}
