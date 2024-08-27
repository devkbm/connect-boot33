package com.like.system.login.domain;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
//@Entity
//@Table(name = "COMLOGINSOCIAL")
public class SocialLogin extends AbstractAuditEntity {

	@EmbeddedId
	SocialLoginID id;
		
	@Column(name="NAME")
	String name;
	
	@Column(name="EMAIL")
	String email;	
	
	@Column(name="USER_ID")
	String userId;
	
	@Column(name="USE_YN")
	String useYn;
}
