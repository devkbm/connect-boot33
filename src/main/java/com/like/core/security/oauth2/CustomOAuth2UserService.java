package com.like.core.security.oauth2;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.like.system.user.adapter.out.persistence.jpa.repository.SystemUserRepository;
import com.like.system.user.domain.QSystemUser;
import com.like.system.user.domain.SystemUser;

import lombok.extern.slf4j.Slf4j;

// http://localhost:8090/oauth2/authorization/google

@Slf4j
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	
	private final SystemUserRepository userRepository;
	private final SocialLoginRepository socialLoginRepository;
		   
	CustomOAuth2UserService(SystemUserRepository userRepository
						   ,SocialLoginRepository socialLoginRepository) {
		this.userRepository = userRepository;		
		this.socialLoginRepository = socialLoginRepository;
	}
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
							
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);			
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration()
												  .getProviderDetails()
												  .getUserInfoEndpoint()
												  .getUserNameAttributeName();
		
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		// {sub=112050878942662954589, name=김병민, given_name=병민, family_name=김, picture=https://lh3.googleusercontent.com/a/ACg8ocIMTjbjyQTYA9qtpQisXrW2rh5DaP4Vh3lQiHL8o14qwrj_oA=s96-c, email=devkbm0417@gmail.com, email_verified=true}
		
		log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		log.info(oAuth2User.getAttributes().get(userNameAttributeName).toString());
		log.info(oAuth2User.getAttributes().toString());		
		
		log.info(registrationId);
		log.info(userNameAttributeName);		
		log.info(attributes.getNameAttributeKey());
		log.info(attributes.getAttributes().toString());
		log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		log.info("bbbbbbbbbbbbbbbbbbbb");
		//log.info(userRequest.toString());
		//log.info(userRequest.getAdditionalParameters().toString());			
		
		log.info("bbbbbbbbbbbbbbbbbbbb");
		
		//User user = saveOrUpdate(attributes);
		//httpSession.setAttribute("user", user);	
		
		// 1. 유저 키로 소셜 로그인 정보가 있는지 검사
		SocialLogin socialLoginInfo = this.findSocialLoginInfo(new SocialLoginID(registrationId, oAuth2User.getAttributes().get(userNameAttributeName).toString()))
										  .orElse(null);		
		
		SystemUser systemUser = null;
		// 2. 로그인 정보가 없을 경우 사용자 정보에서 이메일이 동일한 사용자 검색하여
		//    소셜 로그인 정보 저장
		if (socialLoginInfo == null) {
	
			systemUser = this.findSystemUserByEmail(oAuth2User.getAttributes().get("email").toString())
 			 		         .orElseThrow(() -> new RuntimeException("동일한 이메일 정보를 가진 사용자가 없습니다."));
			
			socialLoginInfo = SocialLogin.newSocialLogin(new SocialLoginID(registrationId, oAuth2User.getAttributes().get(userNameAttributeName).toString())
														,oAuth2User.getAttribute("name")
														,oAuth2User.getAttribute("email")
														,userNameAttributeName);
			
			saveSocialLoginInfo(socialLoginInfo);
		} else {
			// 
		}
		
		// 4. 정보가 있으면 로그인 진행
		
		return new DefaultOAuth2User(
               Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
               attributes.getAttributes(),
               attributes.getNameAttributeKey());       
	}
	
	private Optional<SystemUser> findSystemUserByEmail(String email) {		
		return this.userRepository.findBy(QSystemUser.systemUser.email.eq(email), q-> q.first());
	}
	
	private Optional<SystemUser> findSystemUser(String userId) {
		return null;
		//return this.userRepository.findById(QSystemUser.systemUser.email.eq(email), q-> q.first());
	}
	
	private Optional<SocialLogin> findSocialLoginInfo(SocialLoginID id) {
		return this.socialLoginRepository.findById(id);
	}
	
	private void saveSocialLoginInfo(SocialLogin entity) {
		this.socialLoginRepository.save(entity);
	}
	
	private SystemUser saveOrUpdate(OAuthAttributes attributes) {
		SystemUser user = null;// userRepository.findById(attributes.getEmail()).orElse(null);
	       
		//userRepository.save(user);
	       
		return user; 
	}

}
