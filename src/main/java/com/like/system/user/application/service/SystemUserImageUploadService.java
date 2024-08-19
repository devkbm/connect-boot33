package com.like.system.user.application.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.like.system.user.adapter.out.persistence.file.SystemUserProfileImageUploader;
import com.like.system.user.application.port.in.SystemUserImageUploadUseCase;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;

@Transactional
@Service
public class SystemUserImageUploadService implements SystemUserImageUploadUseCase {

	SystemUserCommandDbPort port;
	SystemUserProfileImageUploader uploader;
	
	SystemUserImageUploadService(SystemUserCommandDbPort port, SystemUserProfileImageUploader uploader) {
		this.port = port;
		this.uploader = uploader;
	}
	
	@Override
	public String upload(String companyCode, String userId, MultipartFile file) throws FileNotFoundException, IOException {
		SystemUser user = this.port.select(companyCode, userId);
		
		if (user == null) return null;
									
		String path = uploader.uploadImage(companyCode, userId, file);
		user.setImage(path);			
		
		this.port.save(user);
		
		return path;
	}

	@Override
	public String saveUploadImagePath(String companyCode, String userId, File file) throws FileNotFoundException, IOException {
		SystemUser user = this.port.select(companyCode, userId);
		
		if (user == null) return null;
						
		String path = file.getCanonicalPath();
		user.setImage(path);			
		
		this.port.save(user);
		
		return path;
	}

}
