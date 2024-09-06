package com.like.system.user.port.in.app.save;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.port.in.SystemUserSaveDTO;

public class SystemUserSaveDTOMapper {

	public static SystemUserSaveDTO toDTO(SystemUser entity, String companyCode) {					
		
		if (entity == null) return null;
		
		//Optional<Dept> dept = Optional.ofNullable(entity.getDept());			
		
		SystemUserSaveDTO dto = SystemUserSaveDTO.builder()																		   
										   .userId(entity.getId().getUserId())										   
										   .name(entity.getName())												   										   
										   .mobileNum(entity.getMobileNum())
										   .email(entity.getEmail())
										   .imageBase64(entity.getImage())
										   .enabled(entity.isEnabled())	
										   .accountNonExpired(entity.isAccountNonExpired())
										   .accountNonLocked(entity.isAccountNonLocked())
										   .credentialsNonExpired(entity.isCredentialsNonExpired())
										   //.companyCode(entity.getStaffId().getCompanyCode())
										   //.staffNo(entity.getStaffId().getStaffNo())
										   //.deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
										   //.deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
										   .roleList(entity.getRoleList(companyCode)
														   .stream()
														   .map(auth -> auth.getAuthority())
														   .toList())										   
										   .build();
		
		return dto;
	}
}
