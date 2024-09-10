package com.like.cooperation.board.port.out;

import java.util.List;

import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;

public interface ArticleQueryByListDbPort {

	List<ArticleResponseDTO> getList(ArticleQueryDTO dto);		
}
