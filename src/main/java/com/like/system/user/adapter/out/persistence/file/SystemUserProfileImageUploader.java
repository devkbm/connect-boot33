package com.like.system.user.adapter.out.persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class SystemUserProfileImageUploader {
	
	UserImagePathProperties properties;
	
	SystemUserProfileImageUploader(UserImagePathProperties properties) {		
		this.properties = properties;
	}
	
	public String uploadImage(String companyCode, String userId, MultipartFile sourceFile) throws FileNotFoundException, IOException {
				
		String extension = StringUtils.getFilenameExtension(sourceFile.getOriginalFilename());	
		String filePath = userId + "." + extension;			
				
		File file = new File(properties.uploadPath(), filePath);
		copy(sourceFile, file);
							
		return Paths.get(properties.uploadPath(), filePath).toString();
	}
	
	private void copy(MultipartFile sourceFile, File file) throws FileNotFoundException, IOException {
		if(sourceFile == null || sourceFile.isEmpty()) throw new FileNotFoundException();				
								
		try (ReadableByteChannel	cin = Channels.newChannel(sourceFile.getInputStream());	
			 FileOutputStream 		fos = new FileOutputStream(file);
			 FileChannel 			cout = fos.getChannel();) {			
						
			 cout.transferFrom(cin, 0, sourceFile.getInputStream().available());						 				
		}			
	}
		
}
