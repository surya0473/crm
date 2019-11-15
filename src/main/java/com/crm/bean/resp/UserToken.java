package com.crm.bean.resp;

public class UserToken {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserToken(String token) {
		super();
		this.token = token;
	}

}
