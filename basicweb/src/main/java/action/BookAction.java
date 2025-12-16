package action;


import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.interceptor.parameter.StrutsParameter;

import dao.BookDao;

import model.Book;
import model.BorrowedBooks;

public class BookAction {
	
	 public static String bookName;
	Book book=new Book();
	BorrowedBooks bb=new BorrowedBooks();
	@StrutsParameter(depth=1)
	public BorrowedBooks getBb() {
		return bb;
	}
	@StrutsParameter
	public void setBb(BorrowedBooks bb) {
		this.bb = bb;
	}
	ArrayList<Book> ls =new ArrayList<>();
	@StrutsParameter(depth=1)
	public Book getBook() {
		return book;
	}
	@StrutsParameter
	public void setBook(Book book) {
		this.book = book;
	}
	@StrutsParameter(depth=1)
	public ArrayList<Book> getLs() {
		return ls;
	}
	@StrutsParameter
	public void setLs(ArrayList<Book> ls) {
		this.ls = ls;
	}
	public String insert() {
		int i=0;
		try {
			i=BookDao.insertBook(book);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		return i>0?"success":"error";
	}
	public String select() throws Exception {
		 System.out.println(">>> select() method triggered");
		try {
			ls=BookDao.selectBook();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("hello");
		return "success";
		
	}
	
	public String getBookName() {
		return bookName;
	}
	@StrutsParameter
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String buyBooks() throws SQLException {
		int i=0;
		try {
			i=BookDao.assignBook(bb);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i>0?"success":"error";
		
	}

}
