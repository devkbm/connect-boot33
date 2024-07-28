package com.like.system.user.domain.vo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.like.system.file.adapter.out.file.FileServerRepository;

@Repository
public class SystemUserProfileImageUploader {
	
	FileServerRepository fileServerRepository;
	
	SystemUserProfileImageUploader(FileServerRepository fileServerRepository) {
		this.fileServerRepository = fileServerRepository;
	}
	
	public String uploadImage(MultipartFile sourceFile) {
		String filePath = UUID.randomUUID().toString();
		
		try {						
			fileServerRepository.fileTransfer(sourceFile, filePath);
		} catch (IOException e) {			
			e.printStackTrace();
		}
					
		return Paths.get(fileServerRepository.getFileServerUploadPath(), filePath).toString();
	}
}
