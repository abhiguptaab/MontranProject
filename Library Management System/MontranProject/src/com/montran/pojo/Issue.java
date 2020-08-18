package com.montran.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "book_issue_master")
public class Issue {

	@Id
	
	@Column(name = "book_issue")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueSerialNumber;
	@Column(name = "date_of_issue")
	private Date issueDate;
	@Column(name = "date_of_return")
	private Date returnDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_code")
	private Book_Master books;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_code")
	private Member_Master member;
	

	public int getIssueSerialNumber() {
		return issueSerialNumber;
	}


	public void setIssueSerialNumber(int issueSerialNumber) {
		this.issueSerialNumber = issueSerialNumber;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public Member_Master getMember() {
		return member;
	}


	public void setMember(Member_Master member) {
		this.member = member;
	}


	public Book_Master getBooks() {
		return books;
	}


	public void setBooks(Book_Master books) {
		this.books = books;
	}


	public Issue(int issueSerialNumber, Date issueDate, Date returnDate, Member_Master member, Book_Master books) {
		super();
		this.issueSerialNumber = issueSerialNumber;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.member = member;
		this.books = books;
	}
	


	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Issue [issueSerialNumber=" + issueSerialNumber + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", member=" + member + ", books=" + books + "]";
	}
	
	
	
	
		
}
