package com.like.system.user.export;

import java.util.Optional;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUser;

public class SystemUserDTOMapper {

	public static SystemUserDTO toDTO(SystemUser entity) {						
		if (entity == null) return null;
		
		//Optional<Dept> dept = Optional.ofNullable(entity.getDept());			
		
		SystemUserDTO dto = SystemUserDTO.builder()								
										 .companyCode("001")
										 .userId(entity.getId().getUserId())
										 //.staffNo(entity.getStaffId().getStaffNo())
										 .name(entity.getName())												   
										 //.deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
										 //.deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
										 .mobileNum(entity.getMobileNum())
										 .email(entity.getEmail())
										 .imageBase64(entity.getImage())
										 .enabled(entity.isEnabled())	
										 .accountNonExpired(entity.isAccountNonExpired())
										 .accountNonLocked(entity.isAccountNonLocked())
										 .credentialsNonExpired(entity.isCredentialsNonExpired())
										 .roleList(entity.getRoleList()
												   		 .stream()
														 .map(auth -> auth.getAuthority())
														 .toList())										   
										 .build();
		
		return dto;
	}
}
