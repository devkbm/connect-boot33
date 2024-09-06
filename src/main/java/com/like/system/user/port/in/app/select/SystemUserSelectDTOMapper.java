package com.like.system.user.port.in.app.select;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.port.in.SystemUserSelectDTO;

public class SystemUserSelectDTOMapper {

	public static SystemUserSelectDTO toDTO(SystemUser entity, String companyCode) {					
		
		if (entity == null) return null;
		
		//Optional<Dept> dept = Optional.ofNullable(entity.getDept());			
		
		SystemUserSelectDTO dto = SystemUserSelectDTO.builder()								
										   //.companyCode(entity.getStaffId().getCompanyCode())
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
										   .roleList(entity.getRoleList(companyCode)
														   .stream()
														   .map(auth -> auth.getAuthority())
														   .toList())										   
										   .build();
		
		return dto;
	}
}
