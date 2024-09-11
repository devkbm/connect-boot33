package com.like.cooperation.board.port.in.article.dto;

import java.util.ArrayList;
import java.util.List;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.util.Base64Util;
import com.like.core.util.SessionUtil;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileResponseDTO;

public class ArticleResponseDTOMapper {
	
	public static ArticleResponseDTO toDTO(Article entity, List<FileInfoDTO> list) {
		
    	if (entity == null) return null;
    	
		//List<ArticleAttachedFile> fileInfoList = entity.getAttachedFileInfoList();
		List<FileResponseDTO> responseList = convertFileResponseDTO(list);
							
		return ArticleResponseDTO
				 .builder()
				 .createdDt(entity.getCreatedDt())
				 .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				 .modifiedDt(entity.getModifiedDt())
				 .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())
				 .articleId(Base64Util.toBase64Encode(entity.getArticleId()))
				 .articleParentId(entity.getArticleParentId())							 
				 .userName(entity.getUserName())
				 .boardId(Base64Util.toBase64Encode(entity.getBoard().getBoardId()))				
				 .title(entity.getContent().getTitle())
				 .contents(entity.getContent().getContents())
				 .fileList(responseList)			
				 .editable(entity.getEditable(SessionUtil.getUserId()))
				 .build();
	}	
	
	private static List<FileResponseDTO> convertFileResponseDTO(List<FileInfoDTO> fileInfoList) {
    	List<FileResponseDTO> responseList = new ArrayList<>();	
    	
    	for (FileInfoDTO fileInfo : fileInfoList) {							
			responseList.add(FileResponseDTO.convert(fileInfo));				
		}
    	
    	return responseList;
    }	
}
