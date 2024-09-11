package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.jpa.ArticleJpaRepository;
import com.like.cooperation.board.adapter.out.db.mybatis.BoardMapper;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTOMapper;
import com.like.cooperation.board.port.out.ArticleQueryByListDbPort;
import com.like.system.file.export.FileInfoDTOSelectUseCase;

@Repository
public class ArticleQueryDbAdapter implements ArticleQueryByListDbPort {
	
	ArticleJpaRepository repository;
	BoardMapper boardMapper;	
	FileInfoDTOSelectUseCase fileSelectUseCse;
	
	ArticleQueryDbAdapter(ArticleJpaRepository repository
			             ,BoardMapper boardMapper
			             ,FileInfoDTOSelectUseCase fileSelectUseCse) {
		this.repository = repository;
		this.boardMapper = boardMapper;
		this.fileSelectUseCse = fileSelectUseCse;
	}
	
	@Override
	public List<ArticleResponseDTO> getList(ArticleQueryDTO dto) {
		
		return this.repository.findAll(dto.getBooleanBuilder(), Sort.by(Sort.Direction.DESC, "articleId"))
							  .stream()
							  .map(e -> ArticleResponseDTOMapper.toDTO(e, fileSelectUseCse.select(e.getFileIds())))
							  .toList();
	}

}
