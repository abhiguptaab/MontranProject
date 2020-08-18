package com.montran.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.montran.dao.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.Date;
import java.util.List;
import com.montran.form.deleteBookForm;
import com.montran.pojo.*;
public class deleteBookAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String bookcode;
		String memberCode;
		Date returnDate=null;
		Date issueDate=null;
		int serialno=0;
		Issue issue = new Issue();
		Book_Master books =new Book_Master();
		Member_Master member = new Member_Master();
		deleteBookForm deletebookform = (deleteBookForm)form;
		String bookCode = deletebookform.getBookCode();
		LibraryDAO dao = new LibraryDAO();
		List<Issue> issueList = dao.getIssuedBooks(); 
		for (int i = 0; i < issueList.size(); i++) {
			if(issueList.get(i).getBooks().getBookId().equals(bookCode)) {
				books = issueList.get(i).getBooks();                              // Get Book of bookCode
				member = issueList.get(i).getMember();								// Get member
				returnDate = issueList.get(i).getReturnDate();						//get return date of issued date
				issueDate = issueList.get(i).getIssueDate();				
				serialno = issueList.get(i).getIssueSerialNumber();
				books.setStatus("Yes");												//set status of book to Yes 
				member.setNo_of_books_issue(member.getNo_of_books_issue()-1);
			}
		}
		
		issue.setBooks(books);
		issue.setMember(member);
		issue.setIssueDate(issueDate);
		issue.setReturnDate(returnDate);
		issue.setIssueSerialNumber(serialno);
		dao.Delete(issue);												 
		dao.Insert(books);
		dao.Insert(member);
		return mapping.findForward("success");
	}
}
