package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import action.BookAction;
import model.Book;
import model.BorrowedBooks;


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
			String Query="select * from Book order by title";
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
	
		
	public static int assignBook(BorrowedBooks bb) throws SQLException {
		String bookName=BookAction.bookName;
		Connection con=null;
		String Query="select bookId from Book where title=?";
		Integer id=null;
		Integer status=null;
		PreparedStatement stmt;
		try {
			con=StudentDao.getConnection();
			stmt=con.prepareStatement(Query);
		stmt.setString(1,bookName);
		 ResultSet rs=stmt.executeQuery();
		 if (rs.next()) {
	         id = rs.getInt("bookId");
	     } else {
	         System.out.println("Book not found!");
	     }
		 Query="insert into BorrowedBook(bookId,rollNum,borrowDate,returnDate) values(?,?,?,?)";
			stmt=con.prepareStatement(Query);
			stmt.setInt(1,id);
			stmt.setString(2,bb.getRollNum());
			stmt.setString(3,bb.getBorrowDate());
			stmt.setString(4,bb.getReturnDate());
			status=stmt.executeUpdate();
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return status;
		
	}
}
