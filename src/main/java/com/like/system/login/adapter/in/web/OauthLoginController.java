package com.like.system.login.adapter.in.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.like.system.authentication.domain.AuthenticationToken;
import com.like.system.user.application.service.SystemUserSelectService;
import com.like.system.user.domain.SystemUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class OauthLoginController {
	
	private SystemUserSelectService userService;
	 
	private OAuth2AuthorizedClientService authorizedClientService;
	
    private RestTemplateBuilder restTemplateBuilder;
    
    public OauthLoginController(SystemUserSelectService userService
    						   ,OAuth2AuthorizedClientService authorizedClientService
    						   ,RestTemplateBuilder restTemplateBuilder) {
    	this.userService = userService;
    	this.authorizedClientService = authorizedClientService;
    	this.restTemplateBuilder = restTemplateBuilder;    	
    }
    
    @GetMapping("/ex")
    public ModelAndView exRedirect1() {
		RestTemplate restTemplate = this.restTemplateBuilder.build();
		
		String msg = restTemplate.getForObject("https://accounts.google.com/o/oauth2/v2/auth?\r\n" + 
				"		scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fcalendar.readonly%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fcalendar&\r\n" + 
				"		access_type=offline&\r\n" + 
				"		include_granted_scopes=true&\r\n" + 
				"		response_type=code&\r\n" + 
				"		state=state_parameter_passthrough_value&\r\n" + 
				"		redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fcallback&\r\n" + 
				"		client_id=497322312042-mstkseqfmr5t8r7nch5bp17r9lh5eoen.apps.googleusercontent.com", String.class);
		
		log.info(msg);
		
        return new ModelAndView("redirect:http://localhost:8090/oauth2/authorization/google");
    }       
               
    @GetMapping("/authToken")
    public AuthenticationToken getAuthToken(OAuth2AuthenticationToken authentication, HttpSession session, HttpServletRequest request) {
    	log.info("/authToken");
    	       
		return (AuthenticationToken)session.getAttribute("user");
    } 
    
    // 최초 로그인 성공
    // http://localhost:8090/oauth2/authorization/google
    // http://localhost:8090/oauth2/authorization
    @GetMapping("/loginSuccess")
    public AuthenticationToken getLoginInfo(OAuth2AuthenticationToken authentication, HttpSession session, HttpServletRequest request) {
    	log.info("/loginSuccess");
    	
    	AuthenticationToken token = null;
    	
        OAuth2AuthorizedClient client = authorizedClientService
          .loadAuthorizedClient(
            authentication.getAuthorizedClientRegistrationId(), 
              authentication.getName());
        
        log.info(client.getAccessToken().getTokenValue());        
    	log.info(client.getRefreshToken() != null ? client.getRefreshToken().getTokenValue() : "null");
    	
    	SystemUser user = null; //userService.selectDTO("001","1");
		    	
		//List<GrantedAuthority> authorities = (List<GrantedAuthority>)user.getAuthorities();           						
        //authentication("1", "1234", authorities, session);         		 							       
        
        //userService.saveLogInOutHistory(new LogInOutHistory("1", "LOGIN", this.getClientIp(request), true));
				
		//token = AuthenticationToken.of(user, request);
		
		session.setAttribute("user", token);
					
		return token;
    } 
    
    @GetMapping("/login/oauth2/code/google")
    public ModelAndView getLogin1(OAuth2AuthenticationToken authentication, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) {
    	log.info("/login/oauth2/code/google");    	    	    	
		
		redirectAttributes.addFlashAttribute("token", session.getId());	
		
		return new ModelAndView("redirect:http://localhost:4200/login/" + session.getId());
    	
    }
}
