package com.stk.car.security;

import org.springframework.security.core.GrantedAuthority;

public class Profile implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	private String profileName;
	
	public Profile(){
	}
	
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getAuthority() {
		return this.profileName;
	}

}