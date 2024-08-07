package com.like.system.user.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface SystemUserImageUploadUseCase {
	
	String upload(String companyCode, String userId, MultipartFile file);
}
