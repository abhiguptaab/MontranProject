package com.montran.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.montran.pojo.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.LibraryDAO;
import com.montran.form.updateBookForm;
import com.montran.pojo.Issue;

import java.util.Date;
import java.util.List;

public class updateBookAction extends Action {

		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			updateBookForm updatebookform = (updateBookForm) form;
			String bookCode = updatebookform.getBookCode();
			String memberCode = updatebookform.getMemberCode();
			Date returnDate =null;
			Date issueDate = null;
			LibraryDAO dao = new LibraryDAO();
			Book_Master books = new Book_Master();
			Member_Master members = new Member_Master();
			Issue issue = new Issue();
			Book_Master book = new Book_Master();
			int serialno =0;
			List<Issue> issuelist = dao.getIssuedBooks();
			List<Book_Master> booklist = dao.getAllBooks();
			
			for(int i=0; i<issuelist.size(); i++) {                                         //getting book_issue_master details for member id
				if(issuelist.get(i).getMember().getMemberId().equals(memberCode)) {
					//books = issuelist.get(i).getBooks();
					returnDate = issuelist.get(i).getReturnDate();
					issueDate = issuelist.get(i).getIssueDate();
					members = issuelist.get(i).getMember();
					serialno = issuelist.get(i).getIssueSerialNumber();
				}
				
			}
			for(int i=0; i<booklist.size(); i++) {											// found new book of given book code
				if(booklist.get(i).getBookId().equals(bookCode) && booklist.get(i).getStatus().equals("Yes")) {     //if book is available
					books = booklist.get(i);
				}
			}
			
			//if(dao.checkBookStatus(booklist, bookCode))
			serialno = Integer.parseInt(updatebookform.getSerialno());
			issue.setIssueSerialNumber(serialno);
			books.setStatus("No");
			issue.setBooks(books);
			issue.setIssueDate(issueDate);
			issue.setMember(members);
			issue.setReturnDate(returnDate);	
			
			System.out.println(issue);
			dao.Update(issue);
			return mapping.findForward("success");
		}
		
}
