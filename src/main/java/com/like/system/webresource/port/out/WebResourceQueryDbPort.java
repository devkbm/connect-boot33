package com.like.system.webresource.port.out;

import java.util.List;

import com.like.system.webresource.domain.WebResource;
import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;

public interface WebResourceQueryDbPort {
	List<WebResource> getResourceList(WebResourceQueryDTO condition);
}
