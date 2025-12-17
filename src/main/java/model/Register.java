package model;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Register {
	String userName;
	String email;
	String password;
	
	
	public void setPassword(String password) {
		this.password = BCrypt.withDefaults().hashToString(10,password.toCharArray());;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	

}
