package com.like.hrm.staff.adapter.in.web.schoolcareer;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.port.in.schoolcareer.StaffSchoolCareerSelectUseCase;
import com.like.hrm.staff.dto.StaffSchoolCareerSaveDTO;

@RestController
public class StaffSchoolCareerSelectController {

	private StaffSchoolCareerSelectUseCase useCase;
		
	public StaffSchoolCareerSelectController(StaffSchoolCareerSelectUseCase useCase) {
		this.useCase = useCase;
	}	
	
	@GetMapping("/api/hrm/staff/{staffId}/schoolcareer/{seq}")
	public ResponseEntity<?> getSchoolCareer(@RequestParam String companyCode
											,@PathVariable String staffId
											,@PathVariable Long seq) {			
		StaffSchoolCareerSaveDTO dto = useCase.select(companyCode, staffId, seq);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
		
}
