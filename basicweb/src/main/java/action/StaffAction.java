package action;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import dao.StaffDao;
import dao.StudentDao;
import model.Staff;

public class StaffAction {
	Staff st=new Staff();
	ArrayList<Staff> ar=new ArrayList<>();
	@StrutsParameter(depth=1)
	public Staff getSt() {
		return st;
	}
	@StrutsParameter
	public void setSt(Staff st) {
		this.st = st;
	}
	public ArrayList<Staff> getAr() {
		return ar;
	}
	@StrutsParameter
	public void setAr(ArrayList<Staff> ar) {
		this.ar = ar;
	}
	public String insert() {
		int i=0;
		try {
			i=StaffDao.insertStaff(st);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		return i>0?"success":"error";
	}
	public String select() throws Exception {
		 System.out.println(">>> select() method triggered");
		try {
			ar=StaffDao.selectStaff();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("hello");
		return "success";
		
	}

}
