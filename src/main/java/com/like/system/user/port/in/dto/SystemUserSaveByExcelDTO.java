package com.like.system.user.port.in.dto;

import java.util.List;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUserAccountAttribute;
import com.like.system.user.domain.SystemUser;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SystemUserSaveByExcelDTO(		
		String clientAppUrl,
		String userId,
		@NotBlank(message="조직코드를 선택해 주세요.")
		String companyCode,
		@NotBlank(message="직원번호를 입력해 주세요.")
		String staffNo,
		String name,
		String deptCode,		
		String mobileNum,
		String email,			
		Boolean enabled,
		List<String> roleList,
		List<String> menuGroupList
		) {
	
	public SystemUser newUser(Dept dept) {
		SystemUser entity = SystemUser.builder()										  
									  .name(this.name)											  
									  .userId(this.staffNo)									  			
									  .mobileNum(this.mobileNum)
									  .email(this.email)					  
									  .accountSpec(new SystemUserAccountAttribute(true, true, true, true))										  										  			 
									  .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;			
	}
					
}
