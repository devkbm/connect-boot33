package com.like.system.login.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class SocialLogin {

	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="USER_ID")
	String userId;
	
	SocialLoginENUM social;
	
	String token;
	
	LocalDateTime lastedLoginDate;
}
