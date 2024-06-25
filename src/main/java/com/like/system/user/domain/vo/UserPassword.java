package com.like.system.user.domain.vo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class UserPassword implements Serializable {
	
	private static final long serialVersionUID = 5831655386795107265L;
	private static final String INIT_PASSWORD = "12345678";
	
	@Column(name="pwd")
	String password;		
		
	public UserPassword() {			
	}
			
	public void change(String rawPassword) {
		this.password = rawPassword;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public static String getInitPassword() {
		return INIT_PASSWORD;
	}
	
}
