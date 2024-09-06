package com.like.system.file.port.in.app;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.file.domain.FileInfo;
import com.like.system.file.port.in.FileDTO;
import com.like.system.file.port.in.FileServerDownloadUseCase;
import com.like.system.file.port.out.FileInfoCommandDbPort;

@Transactional
@Service
public class FileSeverDownloadService implements FileServerDownloadUseCase {

	FileInfoCommandDbPort dbPort;
	
	FileSeverDownloadService(FileInfoCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public FileDTO getDownloadFile(String fileInfoId) {
		FileInfo fileInfo = this.dbPort.getFileInfo(fileInfoId);		
		File file = new File(fileInfo.getPath(), fileInfo.getUuid()); 
		
		fileInfo.plusDownloadCount();		
		
		this.dbPort.save(fileInfo);
		
		return new FileDTO(file, fileInfo.getSize(), fileInfo.getFileName(), fileInfo.getContentType());
	}

}
