package com.montran.form;
import org.apache.struts.action.ActionForm;

public class deleteBookForm extends ActionForm{
	private String bookCode;

	
	public deleteBookForm() {
		super();	
	}
	
	public deleteBookForm(String bookCode) {
		super();
		this.bookCode = bookCode;
	}
	
	
	

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	
	
}
