package com.like.cooperation.board.port.in.article.app;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.board.port.in.article.ArticleQueryBySliceUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleListDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.out.ArticleQueryBySliceDbPort;

@Transactional(readOnly = true)
@Service
public class ArticleQueryBySliceService implements ArticleQueryBySliceUseCase {

	ArticleQueryBySliceDbPort dbPort;
	
	ArticleQueryBySliceService(ArticleQueryBySliceDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public Slice<ArticleListDTO> getAritlceSlice(String userId, ArticleQueryDTO dto, Pageable pageable) {
		return this.dbPort.getAritlceSlice(userId, dto, pageable);
	}

	
}
