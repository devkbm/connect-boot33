package com.like.system.user.domain;

import org.springframework.security.core.GrantedAuthority;

import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.system.role.adapter.out.persistence.jpa.entity.JpaRole;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity
@Table(name = "COMUSERROLE")
public class SystemUserRole extends AbstractAuditEntity implements GrantedAuthority {
	
	private static final long serialVersionUID = 8196330930609694251L;

	@EmbeddedId
	SystemUserRoleId id;
	
	@MapsId("userId") 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORG_CD", referencedColumnName = "ORG_CD"),
		@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	})
	SystemUser systemUser;
		
	public SystemUserRole(SystemUser systemUser, JpaRole authority) {
		
		this.id = new SystemUserRoleId(systemUser.getId().getCompanyCode()
										   ,systemUser.getId().getUserId()
										   ,authority.getRoleCode());
		this.systemUser = systemUser;
		//this.authority = authority;		
	}
	
	@Override
	public String getAuthority() {
		return this.id.getRoleCode();
	}

	public String getCompanyCode() {
		return this.id.getUserId().getCompanyCode();
	}

	public String getUserId() {
		return this.id.getUserId().getUserId();
	}

	public String getRoleCode() {
		return this.id.getRoleCode();
	}
	
}
