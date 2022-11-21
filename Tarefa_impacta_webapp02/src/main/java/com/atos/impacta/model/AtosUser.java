package com.atos.impacta.model;

public class AtosUser {

	private String username;
	private String password;
	private String email;
	
	public AtosUser() {}
	
	public AtosUser(String username2, String password2,String email2) {
		this.username=username2;
		this.password=password2;
		this.email=email2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
