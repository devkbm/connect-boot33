package com.like.system.company.domain;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import lombok.Getter;

@Getter
public class CompanyInfo {

	@EmbeddedId
	CompanyInfoId id;
	
	String companyName;
	
	// 사업자등록번호
	String businessRegistrationNumber;
	
	// 법인번호
	String coporationNumber;
		
	// 대표자명(성명)
	String nameOfRepresentative;
	
	// 설립일
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
