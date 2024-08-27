package com.like.core.security.oauth2;

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
@Entity
@Table(name = "COMLOGINSOCIAL")
public class SocialLogin extends AbstractAuditEntity {

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
}
