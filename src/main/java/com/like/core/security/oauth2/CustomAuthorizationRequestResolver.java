package com.like.core.security.oauth2;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

// https://ordilov.github.io/posts/Spring%20Security%20OAuth2%20Client

@Component
public class CustomAuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {

	private final OAuth2AuthorizationRequestResolver defaultAuthorizationRequestResolver;

	public CustomAuthorizationRequestResolver(ClientRegistrationRepository clientRegistrationRepository) {		
	    this.defaultAuthorizationRequestResolver = new DefaultOAuth2AuthorizationRequestResolver(clientRegistrationRepository, "/oauth2/authorization");
	}

	@Override
	public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
		OAuth2AuthorizationRequest authorizationRequest = this.defaultAuthorizationRequestResolver.resolve(request);		
		String companyCode = request.getParameter("companyCode");						
		
		return authorizationRequest != null ? customAuthorizationRequest(authorizationRequest, companyCode) : null;
	}	  
	  	  

	@Override
	public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
	    OAuth2AuthorizationRequest authorizationRequest = this.defaultAuthorizationRequestResolver.resolve(request, clientRegistrationId);
	    String companyCode = request.getParameter("companyCode");
	    	    
	    return authorizationRequest != null ? customAuthorizationRequest(authorizationRequest, companyCode) : null;
	}
		  

	private OAuth2AuthorizationRequest customAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, String companyCode) {

		Map<String, Object> additionalParameters = new LinkedHashMap<>(authorizationRequest.getAdditionalParameters());
				
	    //additionalParameters.put("access_type", "offline");
	    //additionalParameters.put("prompt", "consent");
		
		OAuth2LoginRequestThreadLocal.set(companyCode);

	    return OAuth2AuthorizationRequest.from(authorizationRequest)
	    								 .additionalParameters(additionalParameters)
	    								 .build();
	}
}
