package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;


public class BookDao {
	public static int insertBook(Book b) throws Exception {
	
	 int status =0;
	 Connection con=null;
	
	
	 try{
			//Students table
		 	 con=StudentDao.getConnection();
			con.setAutoCommit(false);// start transaction
			String Query1="insert into Book(title,author,publishedYear,genre) values(?,?,?,?)";
			 PreparedStatement stmt=con.prepareStatement(Query1);
			 
		      stmt.setString(1,b.getTitle());
			stmt.setString(2,b.getAuthor());
			stmt.setInt(3,b.getPublishedYear());
			stmt.setString(4,b.getGenre());
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
	public static ArrayList selectBook() throws Exception {
		Connection con=null;
		ArrayList<Book> ls=new ArrayList<>();
		try {
			con=StudentDao.getConnection();
			
			String Query="select * from Book";
			PreparedStatement stmt=con.prepareStatement(Query);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Book b=new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				b.setAuthor(rs.getString("author"));
				b.setPublishedYear(rs.getInt("publishedYear"));
				b.setGenre(rs.getString("genre"));
				b.setAvailableCopies(rs.getInt("availableCopies"));
				ls.add(b);
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
