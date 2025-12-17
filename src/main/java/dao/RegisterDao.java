package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.Register;

public class RegisterDao {
	
	public static int insertRegister(Register res) throws SQLException {
		int affectedRows=0;
		Connection con=null;
		try {
			 con=StudentDao.getConnection();
			con.setAutoCommit(false);
			String Query="insert into Register(userName,email,password) values(?,?,?)";
			PreparedStatement stmt=con.prepareStatement(Query);
			
			

			stmt.setString(1,res.getUserName());
			stmt.setString(2, res.getEmail());
			stmt.setString(3,res.getPassword());
			affectedRows=stmt.executeUpdate();
			con.commit();
			
		}catch(Exception e) {
			con.rollback();
			e.printStackTrace();
		}
		finally {
			con.close();
			
			
		}
		System.out.println(res.getPassword());
		return affectedRows;
		
	}
	public static int loginCheck(Register r) throws SQLException {
		Connection con=null;
		Integer finder=null;
		try {
			con=StudentDao.getConnection();
			String Query="select 1 as find from Register where email=? and password=?";
			PreparedStatement stmt=con.prepareStatement(Query);
			stmt.setString(1,r.getEmail());
			stmt.setString(2,r.getPassword());
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) {                
		        finder = rs.getInt("find");  
		    } else {
		        finder = 0;                  
		    }

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		System.out.println(r.getPassword());
		return finder;
		
		
	}

}
