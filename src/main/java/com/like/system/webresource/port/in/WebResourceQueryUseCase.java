package com.like.system.webresource.port.in;

import java.util.List;

public interface WebResourceQueryUseCase {

	List<WebResourceSaveDTO> getResourceList(WebResourceQueryDTO condition);
}
