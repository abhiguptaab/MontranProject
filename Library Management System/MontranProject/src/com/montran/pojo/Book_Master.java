package com.montran.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity(name = "book_master")
public class Book_Master {
	
	@Id
	@Column(name = "book_code")
	private String bookId;
	@Column(name = "book_title")
	private String bookName;
	@Column(name = "book_author")
	private String bookPrice;
	@Column(name = "book_issue_status")
	private  String Status;
	
	public Book_Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book_Master(String bookId, String bookName, String bookPrice, String Status) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.Status = Status;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String Status) {
		this.Status = Status;
	}
	@Override
	public String toString() {
		return "Book_Master [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", Status="
				+ Status + "]";
	}
	

	
}
