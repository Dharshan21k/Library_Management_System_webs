package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Student;

public class StudentDao {
	public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/LibraryManagement",
                "root",
                "Dharshan@2004"
        );
    }
static int startNum=1;
	
	public static int insertStudent(Student s) throws Exception {
		Integer id=null;
		 int status =0;
		 Connection con=null;
		
		
		 try{
				//Students table
			 	 con=getConnection();
				con.setAutoCommit(false);// start transaction
				String Query1="insert into Student(rollNum,name,dateOfBirth,bloodGroup,gender,departmentName, enrolledYear) values(?,?,?,?,?,?,?)";
				 PreparedStatement stmt=con.prepareStatement(Query1,PreparedStatement.RETURN_GENERATED_KEYS);
				
				 
				 s.setRollNum(s.getEnrolledYear()+s.getDepartmentName()+(++startNum));
			        stmt.setString(1,s.getRollNum());
				stmt.setString(2,s.getName());
				
				stmt.setString(3,s.getDateOfBirth());
				stmt.setString(4,s.getBloodGroup());
				stmt.setString(5, s.getGender());
				
				stmt.setString(6,s.getDepartmentName());
				stmt.setInt(7,s.getEnrolledYear());
				  status=stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
		        if (rs.next()) {
		            id = rs.getInt(1); 
		            
		        }	
		        
		      
		        
				//Contacts Table
				Query1="insert into Contact(studentID,email,phone,address) values(?,?,?,?)";
				if(id!=null) {
				stmt=con.prepareStatement(Query1);
				}
				stmt.setInt(1,id);
				stmt.setString(2,s.getEmail());
				stmt.setString(3,s.getPhone());
				stmt.setString(4,s.getAddress());
				status=stmt.executeUpdate();
				
				con.commit();
				System.out.println("All Record Added Successfully");
		
	}catch(SQLException e) {
		con.rollback();
	
		e.printStackTrace();
	}
	finally {
		con.setAutoCommit(true);
		con.close();
	}
		 return status;
		 

		
	}
	public static ArrayList selectStudent() throws Exception {
		Connection con=null;
		ArrayList<Student> ls=new ArrayList<>();
		try {
			con=getConnection();
			
			String Query="select s.studentId,s.name,s.rollNum ,s.dateOfBirth ,s.BloodGroup,s.gender,s.departmentName,s.enrolledYear,c.email,c.phone,c.address from Student s inner join Contact c on s.studentId=c.studentId ";
			PreparedStatement stmt=con.prepareStatement(Query);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Student stu=new Student();
				stu.setStudId(rs.getInt("studentId"));
				stu.setName(rs.getString("name"));
				stu.setDateOfBirth(rs.getString("dateOfBirth"));
				stu.setBloodGroup("bloodGroup");
				stu.setGender(rs.getString("gender"));
				stu.setRollNum(rs.getString("rollNum"));
				stu.setPhone(rs.getString("phone"));
				stu.setEmail(rs.getString("email"));
				stu.setAddress(rs.getString("address"));
				stu.setDepartmentName(rs.getString("departmentName"));
				stu.setEnrolledYear(rs.getInt("enrolledYear"));
				ls.add(stu);
			}
			
		}catch(Exception e) {
			
			throw e;
			
		}
		finally {
			con.close();
		}
		return ls;
		
		
	}

}
