package com.like.system.company.domain;

import java.time.LocalDate;

import org.hibernate.envers.Audited;

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
@Audited
@Entity
@Table(name = "COMCOMPANY")
public class CompanyInfo extends AbstractAuditEntity {

	@EmbeddedId
	CompanyInfoId id;
	
	@Column(name="ORG_NM")
	String companyName;
	
	// 사업자등록번호
	@Column(name="BIZ_REG_NO")
	String businessRegistrationNumber;
	
	// 법인번호
	@Column(name="CORP_NO")
	String coporationNumber;
		
	// 대표자명(성명)
	@Column(name="REPR_NM")
	String nameOfRepresentative;
	
	// 설립일
	@Column(name="ESTA_DT")
	LocalDate establishmentDate;
	
	public CompanyInfo(String id
					  ,String companyName
					  ,String businessRegistrationNumber
					  ,String coporationNumber
					  ,String nameOfRepresentative
					  ,LocalDate establishmentDate) {		
		this.id = new CompanyInfoId(id);
		this.companyName = companyName;
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.coporationNumber = coporationNumber;
		this.nameOfRepresentative = nameOfRepresentative;
		this.establishmentDate = establishmentDate;
	}
	
	
}
