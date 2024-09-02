package com.like.system.user.domain;

import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.system.dept.domain.Dept;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "COMUSERCOMPANY")
public class SystemUserCompany extends AbstractAuditEntity {

	@EmbeddedId
	SystemUserCompanyId id;				
	
	@Column(name="DEPT_CD")
	String deptCode;
	
	@OneToOne(optional = true)
	@JoinColumns({
		@JoinColumn(name="ORG_CD", referencedColumnName = "ORG_CD", insertable=false, updatable=false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)),
		@JoinColumn(name = "DEPT_CD", referencedColumnName = "DEPT_CD", insertable=false, updatable=false, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	})	
	Dept dept;
	
	@Column(name="USE_YN")
	Boolean useYn;
	
	@MapsId("userId") 
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	SystemUser systemUser;
	
	public SystemUserCompany(String userId
			                ,String companyCode
			                ,String deptCode
			                ,Boolean useYn) {
		this.id = new SystemUserCompanyId(companyCode, userId);
		this.deptCode = deptCode;
		this.useYn = useYn;		
	}
}