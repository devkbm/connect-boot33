package com.like.login.adapter.in.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.security.oauth2.SystemOauth2User;
import com.like.core.util.SessionUtil;
import com.like.core.web.util.WebRequestUtil;
import com.like.login.domain.AuthenticationToken;
import com.like.login.port.in.AuthenticationTokenSelectUseCase;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationTokenController {

	AuthenticationTokenSelectUseCase useCase;
	
	AuthenticationTokenController(AuthenticationTokenSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/user/auth")
	public AuthenticationToken get(HttpServletRequest request, @RequestParam String companyCode) {
		
		String userId = SessionUtil.getUserId();
		
		return useCase.select(userId
				             ,companyCode
				             ,request.getSession().getId()
				             ,WebRequestUtil.getIpAddress(request));
	}
	
	@GetMapping("/api/system/user/oauth2")
	public AuthenticationToken getOAuth2(HttpServletRequest request, @RequestParam String companyCode) {
		
		String oAuth2UserId = SessionUtil.getUserId();
		
		Authentication a = SecurityContextHolder.getContext().getAuthentication();			
		
		SystemOauth2User user = (SystemOauth2User)a.getPrincipal();
		
		return useCase.select(user.getUserId()
				             ,companyCode
				             ,request.getSession().getId()
				             ,WebRequestUtil.getIpAddress(request));
	}
}
