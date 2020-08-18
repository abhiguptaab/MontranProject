package com.montran.form;

import org.apache.struts.action.ActionForm;

public class updateBookForm extends ActionForm{
	private String serialno;
	private String memberCode;
	private String bookCode;
	
	public updateBookForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public updateBookForm(String memberCode, String bookCode, String serialno) {
		super();
		this.serialno = serialno;
		this.memberCode = memberCode;
		this.bookCode = bookCode;
	}
	
	public String getSerialno() {
		return serialno;
	}
	
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	
	public String getMemberCode() {
		return memberCode;
	}
	
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	
	public String getBookCode() {
		return bookCode;
	}
	
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	
	@Override
	public String toString() {
		return "updateBookForm [memberCode=" + memberCode + ", bookCode=" + bookCode + "]";
	}
	
	
	
}
