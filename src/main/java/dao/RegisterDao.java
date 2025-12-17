package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;
import model.Register;

public class RegisterDao {
	
	public static int insertRegister(Register res) throws SQLException {
		int affectedRows=0;
		Connection con=null;
		try {
			 con=StudentDao.getConnection();
			con.setAutoCommit(false);
			String Query="insert into Register(userName,email,otp,password) values(?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(Query);
			String hashpass=res.getPassword();
			String c=BCrypt.withDefaults().hashToString(10,hashpass.toCharArray());
			int min=1;
			int max=6;
			String otp="";
			for(int i=0;i<6;i++) {
			 otp =(int)(Math.random() * max) + min+otp;
			}
			
			
			stmt.setString(1,res.getUserName());
			stmt.setString(2, res.getEmail());
			System.out.println(otp);
			stmt.setString(3,otp);
			stmt.setString(4,c);
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
			String Query="select password from Register where email=?";
			PreparedStatement stmt=con.prepareStatement(Query);
			stmt.setString(1,r.getEmail());
			
			
			ResultSet rs=stmt.executeQuery();
			
			if (rs.next()) {
			    String storedHash = rs.getString("password");
			    BCrypt.Result result =
			    	    BCrypt.verifyer().verify(
			    	        r.getPassword().toCharArray(),
			    	        storedHash.toCharArray()
			    	    );
			    if (result.verified) {
			        finder = 1;
			    } else {
			        finder = 0;
			    }
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
		return finder;
		
		
	}

}
