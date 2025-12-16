package model;



public class Student {
	private int studId;
	private String name;
	private String dateOfBirth;
	private String bloodGroup;
	private String gender;
	private String rollNum;
	private int conactId;
	private String email;
	private String phone;
	private String address;
	private String departmentName;
	private int enrolledYear;
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public void setEnrolledYear(int enrolledYear) {
		this.enrolledYear = enrolledYear;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public int getEnrolledYear() {
		return enrolledYear;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public int getStudId() {
		return studId;
	}
	public String getName() {
		return name;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	
	
	public String getRollNum() {
		return rollNum;
	}
	
	
	public int getConactId() {
		return conactId;
	}
	
	public void setConactId(int conactId) {
		this.conactId = conactId;
	}
	public String getEmail() {
		return email;
	}

	
	public String getPhone() {
		return phone;
	}
	
	
	public String getAddress() {
		return address;
	}

	
	
	

}
