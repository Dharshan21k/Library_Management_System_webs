package action;

import java.sql.SQLException;
import java.util.ArrayList;


import org.apache.struts2.ActionSupport;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

import dao.StudentDao;
import model.Student;

public class StudentAction extends ActionSupport{
	Student student=new Student();
	 private ArrayList<Student> list=new ArrayList<>();
	 ArrayList<ArrayList<String>> ar=new ArrayList<>();
	  @StrutsParameter(depth = 1)
	public Student getStudent() {
		return student;
	}
	  @StrutsParameter(depth = 1)
public ArrayList<ArrayList<String>> getAr() {
		return ar;
	}
@StrutsParameter
	  public void setAr(ArrayList<ArrayList<String>> ar) {
		  this.ar = ar;
	  }
@StrutsParameter
	public void setStudent(Student student) {
		this.student = student;
	}

	public ArrayList<Student> getList() {
	return list;
}
	@StrutsParameter
public void setList(ArrayList<Student> list) {
	this.list = list;
}
	public String insert() {
		int i=0;
		try {
			i=StudentDao.insertStudent(student);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("name="+student.getRollNum());
		return i>0?"success":"error";
	}
	public String select() throws Exception {
		 System.out.println(">>> select() method triggered");
		try {
			list=StudentDao.selectStudent();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("hello");
		return "success";
		
	}
	public String  selectByOrder() {
		try {
			ar=StudentDao.selectBookStudent();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
		
	}
	

}
