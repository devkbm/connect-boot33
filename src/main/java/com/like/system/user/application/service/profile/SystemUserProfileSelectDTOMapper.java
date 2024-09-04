package com.like.system.user.application.service.profile;

import com.like.system.user.application.port.in.SystemUserProfileSelectDTO;
import com.like.system.user.application.port.in.SystemUserProfileSelectSessionDTO;
import com.like.system.user.domain.SystemUser;

public class SystemUserProfileSelectDTOMapper {

	public static SystemUserProfileSelectDTO toDTO(SystemUser entity, SystemUserProfileSelectSessionDTO session) {
		
		//Optional<Dept> dept = Optional.ofNullable(entity.getDept());			
						
		return SystemUserProfileSelectDTO
				.builder()
				.companyCode("001")
			    .userId(entity.getId().getUserId())
 			    //.staffNo(entity.getStaffId().getStaffNo())
			    .staffName(entity.getName())												   
			    //.deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
			    //.deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
			    .mobileNum(entity.getMobileNum())
 			    .email(entity.getEmail())
 			    .session(session)
 			    /*
 			    .ipAddress(WebRequestUtil.getIpAddress(request))
 			    .lastAccessedTime(new Date(request.getSession().getLastAccessedTime()))
 			    */
				.build();
	}
}