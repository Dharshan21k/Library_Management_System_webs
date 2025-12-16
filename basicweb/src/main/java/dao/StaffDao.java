package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Staff;

public class StaffDao {
static int startNum=0;
	
	public static int insertStaff(Staff s) throws Exception {
		Integer id=null;
		 int status =0;
		 Connection con=null;
		
		
		 try{
				//Students table
			 	 con=StudentDao.getConnection();
				con.setAutoCommit(false);// start transaction
				String Query1="insert into Staff(staffNum,name,dateOfBirth,bloodGroup,gender,departmentName, employedYear) values(?,?,?,?,?,?,?)";
				 PreparedStatement stmt=con.prepareStatement(Query1,PreparedStatement.RETURN_GENERATED_KEYS);
				
				 
				 s.setStaffNum(s.getEmployedYear()+s.getDepartmentName()+(++startNum));
			        stmt.setString(1,s.getStaffNum());
				stmt.setString(2,s.getName());
				
				stmt.setString(3,s.getDateOfBirth());
				stmt.setString(4,s.getBloodGroup());
				stmt.setString(5, s.getGender());
				
				stmt.setString(6,s.getDepartmentName());
				stmt.setInt(7,s.getEmployedYear());
				  status=stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
		        if (rs.next()) {
		            id = rs.getInt(1); 
		            
		        }	
		        
		      
		        
				//Contacts Table
				Query1="insert into Contact(staffId,email,phone,address) values(?,?,?,?)";
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
	public static ArrayList selectStaff() throws Exception {
		Connection con=null;
		ArrayList<Staff> ls=new ArrayList<>();
		try {
			con=StudentDao.getConnection();
			
			String Query="select s.staffId,s.name,s.staffNum ,s.dateOfBirth ,s.BloodGroup,s.gender,s.departmentName,s.employedYear,c.email,c.phone,c.address from Staff s inner join Contact c on s.staffId=c.staffId ";
			PreparedStatement stmt=con.prepareStatement(Query);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Staff st=new Staff();
				st.setStaffId(rs.getInt("staffId"));
				st.setName(rs.getString("name"));
				st.setDateOfBirth(rs.getString("dateOfBirth"));
				st.setBloodGroup("bloodGroup");
				st.setGender(rs.getString("gender"));
				st.setStaffNum(rs.getString("staffNum"));
				st.setPhone(rs.getString("phone"));
				st.setEmail(rs.getString("email"));
				st.setAddress(rs.getString("address"));
				st.setDepartmentName(rs.getString("departmentName"));
				st.setEmployedYear(rs.getInt("employedYear"));
				ls.add(st);
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
