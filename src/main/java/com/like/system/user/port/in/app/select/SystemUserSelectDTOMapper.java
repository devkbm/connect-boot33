package com.like.system.user.port.in.app.select;

import java.util.Optional;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.port.in.SystemUserSelectDTO;

import jakarta.persistence.EntityNotFoundException;

public class SystemUserSelectDTOMapper {

	public static SystemUserSelectDTO toDTO(SystemUser entity, String companyCode) {					
		
		if (entity == null) return null;
		
		SystemUserCompany company = entity.getCompanyInfo(companyCode).orElseThrow(() -> new EntityNotFoundException("회사 정보가 없습니다."));
		
		Optional<Dept> dept = Optional.ofNullable(company.getDept());			
		
		SystemUserSelectDTO dto = SystemUserSelectDTO.builder()																		   
										   .userId(entity.getId().getUserId())										   
										   .name(entity.getName())												   										   
										   .mobileNum(entity.getMobileNum())
										   .email(entity.getEmail())
										   .imageBase64(entity.getImage())
										   .enabled(entity.isEnabled())	
										   .accountNonExpired(entity.isAccountNonExpired())
										   .accountNonLocked(entity.isAccountNonLocked())
										   .credentialsNonExpired(entity.isCredentialsNonExpired())
										   .companyCode(company.getId().getCompanyCode())
										   .staffNo(entity.getId().getUserId())
										   .deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
										   .deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
										   .roleList(entity.getRoleList(companyCode)
														   .stream()
														   .map(auth -> auth.getAuthority())
														   .toList())										   
										   .build();
		
		return dto;
	}
}
