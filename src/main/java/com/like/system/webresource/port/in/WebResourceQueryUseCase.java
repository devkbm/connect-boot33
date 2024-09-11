package com.like.system.webresource.port.in;

import java.util.List;

import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.in.dto.WebResourceSaveDTO;

public interface WebResourceQueryUseCase {

	List<WebResourceSaveDTO> getResourceList(WebResourceQueryDTO condition);
}
