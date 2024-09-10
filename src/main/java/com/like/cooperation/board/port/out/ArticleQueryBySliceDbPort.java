package com.like.cooperation.board.port.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.port.in.article.dto.ArticleListDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;

public interface ArticleQueryBySliceDbPort {
	
	Slice<ArticleListDTO> getAritlceSlice(String userId, ArticleQueryDTO dto, Pageable pageable);
}
