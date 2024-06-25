package com.like.hrm.hrmcode.application.service.hrmdependcode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.hrmcode.adapter.out.persistence.springdata.HrmRelationCodeRepository;
import com.like.hrm.hrmcode.domain.HrmRelationCode;
import com.like.hrm.hrmcode.dto.SaveHrmRelationCode;

@Service
@Transactional
public class HrmRelationCodeService {

	private HrmRelationCodeRepository repository;
	
	public HrmRelationCodeService(HrmRelationCodeRepository repository) {
		this.repository = repository;
	}
	
	public HrmRelationCode getRelationCode(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void saveRelationCode(SaveHrmRelationCode dto) {
		HrmRelationCode entity = null;
		
		if (dto.getRelationId() != null) {
			entity = this.getRelationCode(dto.getRelationId());
		} else {
			entity = dto.newHrmRelationCode();
		}
		
		repository.save(entity);
	}
	
	public void deleteRelationCode(Long id) {
		repository.deleteById(id);
	}
}
