package action;

import org.apache.struts2.ActionSupport;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import dao.RegisterDao;
import model.Register;

public class RegisterAction extends ActionSupport{
	Register register=new Register();
	public void validate(){
	    if (register.getUserName().length()== 0 ) {
	        addFieldError("register.userName", "name is required or give correct mail.");
	    }

	    if (register.getEmail().length() == 0 || (!register.getEmail().contains(".com"))) {
	        addFieldError("register.email", "Email is required.");
	    }

	    if (register.getPassword().length() == 0) {
	        addFieldError("register.password", "password is required");
	    }
	}
	@Override
	public String input() {
		Register register=new Register();
	    return INPUT;
	}

@StrutsParameter(depth=1)
	public Register getRegister() {
	
		return register;
	}
@StrutsParameter
	public void setRegister(Register register) {
		this.register = register;
	}

	public String insert() {
		int affectedRows=0;
		try {
			affectedRows=RegisterDao.insertRegister(register);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return affectedRows>0?"success":"error";
	}
	public String select() {
		int finder=0;
		try {
			finder=RegisterDao.loginCheck(register);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return finder>0?"success":"error";
	}
	public String otpVerify() {
		int updatedRecord=0;
		try {
			updatedRecord=RegisterDao.verifyOtp(register);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return updatedRecord>0?"success":"error";
	}
	
}
