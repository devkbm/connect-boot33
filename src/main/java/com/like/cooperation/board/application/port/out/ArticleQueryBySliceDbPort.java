package com.like.cooperation.board.application.port.out;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.dto.ArticleListDTO;
import com.like.cooperation.board.dto.ArticleQueryDTO;

public interface ArticleQueryBySliceDbPort {
	
	Slice<ArticleListDTO> getAritlceSlice(String userId, ArticleQueryDTO dto, Pageable pageable);
}
