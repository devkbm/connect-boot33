package com.like.system.user.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.vo.AccountSpec;
import com.like.system.user.domain.vo.SystemUserProfilePicture;
import com.like.system.user.domain.vo.UserPassword;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "comuser")
public class SystemUser extends AbstractAuditEntity implements UserDetails {	
	
	private static final long serialVersionUID = -4328973281359262612L;
	
	@EmbeddedId
	SystemUserId id;
	
	//@Embedded
	//StaffId staffId;	
	
	@Column(name="USER_NAME")
	String name;
			
	@Embedded
	UserPassword password;
		
	@Embedded
	AccountSpec accountSpec;	
	
	@Column(name="MOBILE_NUM")
	String mobileNum;
	
	@Column(name="EMAIL")
	String email;
				
	@Embedded
	SystemUserProfilePicture image;
	
	/*
	@Column(name="DEPT_CD")
	String deptCode;
	
	@OneToOne(optional = true)
	@JoinColumns({
		@JoinColumn(name="ORG_CD", referencedColumnName = "ORG_CD", insertable=false, updatable=false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)),
		@JoinColumn(name = "DEPT_CD", referencedColumnName = "DEPT_CD", insertable=false, updatable=false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	})	
	Dept dept;
	*/
	
	@OneToMany(mappedBy = "systemUser")
	Set<SystemUserCompanyRole> roles = new LinkedHashSet<>();				
	
	@OneToMany(mappedBy = "systemUser")
	Set<SystemUserCompany> company = new LinkedHashSet<>();
	
	@Builder
	public SystemUser(String companyCode
					 ,String staffNo					 
					 ,String name					 
					 ,UserPassword password
					 ,Dept dept
					 ,String mobileNum
					 ,String email
					 ,AccountSpec accountSpec) {		
		this.id = new SystemUserId(staffNo);
		//this.staffId = new StaffId(companyCode, staffNo);		
		this.name = name;
		this.password = password;
		//this.dept = dept;
		//this.deptCode = dept == null ? null : dept.getId().getDeptCode();
		this.mobileNum = mobileNum;
		this.email = email;
		this.accountSpec = accountSpec;									
	}	
	
	@Builder(builderMethodName = "modifyBuilder", buildMethodName = "modify")
	public void modifyEntity(String companyCode
							,String staffNo
			 				,String name					 				
							,String mobileNum
							,String email							 
							,Dept dept					) {
		//this.staffId = new StaffId(companyCode, staffNo);
		this.name = name;						
		this.mobileNum = mobileNum;
		this.email = email;		
		//this.dept = dept;
		//this.deptCode = dept == null ? null : dept.getId().getDeptCode();				
	}
	
	@Override	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles; //.stream().map(r -> r.getAuthority()).toList();
	}	
		
	@Override	
	public String getUsername() {		
		return id.getUserId();
	}

	@Override		
	public String getPassword() {
		return password.getPassword();
	}		

	@Override
	public boolean isAccountNonExpired() {
		return true;
		//return accountSpec.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
		//return accountSpec.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
		//return accountSpec.getIsCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return true;
		//return accountSpec.getIsEnabled();
	}			
	
	public boolean isVaild(String password) {
		return this.password.matchPassword(password);
	}	

	public Set<SystemUserCompanyRole> getRoleList() {
		return this.roles;		
	}
	
	/*
	public void addRole(JpaRole authority) {
		if (this.roles == null) {
			this.roles = new LinkedHashSet<>();
		}
		
		//this.roles.add(new SystemUserCompanyRole(this, authority));
	}								
	*/
	public void changePassword(String password) {
		if (this.password == null) {
			this.password = new UserPassword();
		} 
						
		this.password.change(password);
	}	
	
	public String getImage() {
		if (this.image == null) return null;
		
		return this.image.getImage();
	}
	/*
	public String changeImage(ProfilePictureRepository profilePictureRepository, MultipartFile sourceFile) {
		if (this.image == null) this.image = new SystemUserProfilePicture(profilePictureRepository);		
		
		return this.image.changeImage(profilePictureRepository, sourceFile);
	}
	*/
	public void setImage(String path) {
		if (this.image == null) this.image = new SystemUserProfilePicture();
		
		this.image.setImagePath(path);
	}
	

	
}
