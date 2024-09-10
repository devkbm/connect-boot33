package com.like.cooperation.board.port.in.article;

import java.util.List;

import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;

public interface ArticleQueryByListUseCase {

	List<ArticleResponseDTO> getList(ArticleQueryDTO dto);		
}
