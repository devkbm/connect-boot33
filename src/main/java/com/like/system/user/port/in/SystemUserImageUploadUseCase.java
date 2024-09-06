package com.like.system.user.port.in;

import java.io.File;
import java.io.IOException;

public interface SystemUserImageUploadUseCase {			
	String saveUploadImagePath(String companyCode, String userId, File file) throws IOException;
}
