package com.like.system.webresource.port.in;

import com.like.system.webresource.port.in.dto.WebResourceSaveDTO;

public interface WebResourceSelectUseCase {

	WebResourceSaveDTO select(String webResourceId);
}
