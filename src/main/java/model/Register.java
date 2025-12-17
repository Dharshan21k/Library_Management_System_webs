package model;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Register {
	String userName;
	String email;
	String password;
	String otp;
	
	
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getOtp() {
		return otp;
	}

}
