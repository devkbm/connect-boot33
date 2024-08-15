package com.like.system.user.application.port.in;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface SystemUserImageUploadUseCase {
	
	String upload(String companyCode, String userId, MultipartFile file) throws FileNotFoundException, IOException;
}
