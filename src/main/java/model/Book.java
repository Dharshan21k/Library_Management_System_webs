package model;

public class Book {
	int bookId ;
	String title;
	String author;
	int publishedYear;
	String genre ;
	int availableCopies;
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public int getBookId() {
		return bookId;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public String getGenre() {
		return genre;
	}

}
