package com.like.core.security.oauth2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "COMLOGINSOCIAL")
public class SocialLogin {	
	
	@EmbeddedId
	SocialLoginID id;
		
	@Column(name="USER_NAME")
	String name;
	
	@Column(name="USER_EMAIL")
	String email;	
	
	@Column(name="USER_ID")
	String userId;
	
	@Column(name="USE_YN")
	Boolean useYn;
	
	@Column(name = "CREATED_DT", updatable = false)
	LocalDateTime createdDt;
	
	//LocalDateTime modifiedDt;
		
	public static SocialLogin newSocialLogin(SocialLoginID id
									 ,String name
									 ,String email
									 ,String userId
									 ) {
		return SocialLogin
				.builder()			
				.id(id)
				.name(name)
				.email(email)
				.userId(userId)
				.useYn(true)
				.createdDt(LocalDateTime.now())
				.build(); 
	}
		
}
