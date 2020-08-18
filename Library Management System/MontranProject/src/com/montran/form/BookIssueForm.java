package com.montran.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BookIssueForm extends ActionForm{
		private String IssueSerialNumber;
		private String memberCode;
		private String memberName;
		private String bookCode;
		private String bookTitle;
		private String bookAuthor;
		private String issueDate;
		private String returnDate;
		
		public BookIssueForm() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public BookIssueForm(String issueSerialNumber, String memberCode, String memberName, String bookCode,
				String bookTitle, String bookAuthor, String issueDate, String returnDate) {
			super();
			IssueSerialNumber = issueSerialNumber;
			this.memberCode = memberCode;
			this.memberName = memberName;
			this.bookCode = bookCode;
			this.bookTitle = bookTitle;
			this.bookAuthor = bookAuthor;
			this.issueDate = issueDate;
			this.returnDate = returnDate;
		}
		
		public String getIssueSerialNumber() {
			return IssueSerialNumber;
		}
		public void setIssueSerialNumber(String issueSerialNumber) {
			IssueSerialNumber = issueSerialNumber;
		}
		public String getMemberCode() {
			return memberCode;
		}
		public void setMemberCode(String memberCode) {
			this.memberCode = memberCode;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		public String getBookCode() {
			return bookCode;
		}
		public void setBookCode(String bookCode) {
			this.bookCode = bookCode;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public String getIssueDate() {
			return issueDate;
		}
		public void setIssueDate(String issueDate) {
			this.issueDate = issueDate;
		}
		public String getReturnDate() {
			return returnDate;
		}
		public void setReturnDate(String returnDate) {
			this.returnDate = returnDate;
		}
		
		@Override
		public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();
			if (getMemberCode() == null || ("".equals(getMemberCode()))) {
				errors.add("common.bookcode.err", new ActionMessage("error.common.bookcode.required"));
			}
			if (getBookCode() == null || ("".equals(getBookCode()))) {
				errors.add("common.membercode.err", new ActionMessage("error.common.membercode.required"));
			}
		return errors;
		}
		
		@Override
		public String toString() {
			return "BookIssueForm [IssueSerialNumber=" + IssueSerialNumber + ", memberCode=" + memberCode
					+ ", memberName=" + memberName + ", bookCode=" + bookCode + ", bookTitle=" + bookTitle
					+ ", bookAuthor=" + bookAuthor + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
		}
		
		
		
}
