package com.like.hrm.hrmcode.adapter.in.web.hrmdependcode;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.hrmcode.port.in.hrmdependcode.app.HrmRelationCodeQueryService;
import com.like.hrm.hrmcode.port.in.hrmdependcode.dto.HrmRelationCodeDTO;

@RestController
public class HrmRelationCodeQueryController {

	private HrmRelationCodeQueryService service;
	
	public HrmRelationCodeQueryController(HrmRelationCodeQueryService service) {
		this.service = service;
	}
	
	@GetMapping("/api/hrm/hrmrelation")
	public ResponseEntity<?> getHrmRelationCode(HrmRelationCodeDTO.SearchHrmRelationCode dto) {
						
		List<?> list = service.getHrmRelationCodeList(dto);
					
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
