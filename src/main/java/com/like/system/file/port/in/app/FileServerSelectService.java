package com.like.system.file.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.file.domain.FileInfo;
import com.like.system.file.port.in.FileServerSelectUseCase;
import com.like.system.file.port.out.FileInfoCommandDbPort;

@Service
public class FileServerSelectService implements FileServerSelectUseCase {

	FileInfoCommandDbPort dbPort;

	FileServerSelectService(FileInfoCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public FileInfo select(String id) {
		return this.dbPort.getFileInfo(id);
	}

	@Override
	public List<FileInfo> select(List<String> ids) {
		return this.dbPort.getFileInfo(ids);
	}
}
