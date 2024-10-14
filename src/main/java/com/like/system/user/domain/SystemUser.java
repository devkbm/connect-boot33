package com.like.system.user.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.like.core.jpa.domain.AbstractAuditEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Audited
@Entity
@Table(name = "comuser")
public class SystemUser extends AbstractAuditEntity implements Serializable {		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	SystemUserId id;	
	
	@Column(name="USER_NAME")
	String name;
			
	@Embedded
	SystemUserPassword password;
		
	@Embedded
	SystemUserAccountAttribute accountSpec;	
	
	@Column(name="MOBILE_NUM")
	String mobileNum;
	
	@Column(name="EMAIL")
	String email;
				
	@Embedded
	SystemUserProfilePicture image;	
	
	@OneToMany(mappedBy = "systemUser")
	Set<SystemUserCompanyRole> roles = new LinkedHashSet<>();				
	
	@OneToMany(mappedBy = "systemUser")
	Set<SystemUserCompany> company = new LinkedHashSet<>();
	
	@Builder
	public SystemUser(String userId					 
					 ,String name					 
					 ,SystemUserPassword password					 
					 ,String mobileNum
					 ,String email
					 ,SystemUserAccountAttribute accountSpec) {		
		this.id = new SystemUserId(userId);	
		this.name = name;
		this.password = password;		
		this.mobileNum = mobileNum;
		this.email = email;
		this.accountSpec = accountSpec;					
	}
	
	@Builder(builderMethodName = "modifyBuilder", buildMethodName = "modify")
	public void modifyEntity(String name					 				
							,String mobileNum
							,String email) {		
		this.name = name;						
		this.mobileNum = mobileNum;
		this.email = email;							
	}			
			
	public String getPassword() {
		return password.getPassword();
	}		
	
	public Optional<SystemUserCompany> getCompanyInfo(String companyCode) {
		return this.getCompany().stream().filter(e -> e.id.companyCode.equals(companyCode)).findFirst();
	}
	
	public List<SystemUserCompanyRole> getRoleList(String companyCode) {
		return this.roles.stream().filter(e -> e.id.getCompanyCode().equals(companyCode)).toList();		
	}
	
	public void setPassword(PasswordEncoder encoder, String password) {
		if (this.password == null) this.password = new SystemUserPassword();		
						
		this.password.set(encoder, password);
	}
	
	public void changePassword(PasswordEncoder encoder, String beforePassword, String afterPassword) {
		if (this.password == null) this.password = new SystemUserPassword();		
						
		this.password.change(encoder, beforePassword, afterPassword);
	}
	
	public String getImage() {
		if (this.image == null) return null;
		
		return this.image.getImage();
	}
	
	public void setImage(String path) {
		if (this.image == null) this.image = new SystemUserProfilePicture();
		
		this.image.setImagePath(path);
	}	
	
}
