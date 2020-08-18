package com.montran.action;
import java.util.Calendar;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.Calendar;
import com.montran.dao.LibraryDAO;
import com.montran.form.BookIssueForm;
import com.montran.pojo.Book_Master;
import com.montran.pojo.Issue;
import com.montran.pojo.Member_Master;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.util.*;
public class IssueBooksAction extends Action{

		@Override
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			String error_msg3 = " ";
			String error_msg2 = " ";
			String error_msg1 = " ";
			LibraryDAO dao = new LibraryDAO();
			List<Issue> issueBookList = dao.getIssuedBooks();
			//List<String> error_msg = new List<String>();
			//String msg ="success";
			BookIssueForm bookissueform = (BookIssueForm) form;
			Issue issue = new Issue();
			Member_Master member = new Member_Master();
			Book_Master books = new Book_Master();
			List<Book_Master> bookList = dao.getAllBooks();
			List<Member_Master> memberList = dao.getAllMembers();
			//Calendar c = Calendar.getInstance();
			int flag = 1;
		
			
			
			if(dao.checkBookStatus(bookList, bookissueform.getBookCode()))  // check status of book (true if bbok is available)
			{
				books.setBookId(bookissueform.getBookCode());
				books.setBookName(bookissueform.getBookTitle());
				books.setBookPrice(bookissueform.getBookAuthor());
				/*for(int i=0; i<bookList.size(); i++) {
					if(bookList.get(i).getBookId().equals(bookissueform.getBookCode())) {
						books = bookList.get(i);
					}
				}
				for(int i=0; i<memberList.size(); i++) {
					if(memberList.get(i).getMemberId().equals(bookissueform.getMemberCode())) {
						member = memberList.get(i);
					}
				}*/
				Date date = new Date();
				Date datef = new Date();
				//DateFormat currentDate = DateFormat.getDateInstance();
				Calendar date1= Calendar.getInstance();
				Calendar date2= Calendar.getInstance();
				date1.add(Calendar.DATE, 30);
				date2.add(Calendar.DATE, 90);
				date=date1.getTime();
				datef=date2.getTime();
				issue.setIssueDate(new Date()); 
				if(dao.checkType(memberList, bookissueform.getMemberCode())) {   //True if Member is Student
					//issue.setReturnDate(currentDate.format(date.getTime() + 30 * 1000 * 60 * 60 * 24)); // Return Date is 30 days after issue of book id member is student
					issue.setReturnDate(date);
					member.setMemberType("student");
					if(member.getNo_of_books_issue()<3) {            //Check if copies of book are less than 3 or not(for student)
						member.setNo_of_books_issue(1);
					}else {
						// Show Error Message
						//
						//msg  = "failure";
						flag = 0;
						error_msg1 = "student book number error";
						request.setAttribute("msg1", error_msg1);
					}
				}
				else {
					issue.setReturnDate(datef);
					member.setMemberType("faculty");
					if(member.getNo_of_books_issue()<=25) {           //Check if copies are less than 25 or not(for faculty)
						member.setNo_of_books_issue(1);
					}else {
						// Show Error Message
						//msg = "failure";
						flag =0;
						error_msg2 = "faculty book number error";
						request.setAttribute("msg2", error_msg2);
					}
				}
				
				//if()
				member.setMemberId(bookissueform.getMemberCode());
				member.setName(bookissueform.getMemberName());
				books.setBookPrice(bookissueform.getBookAuthor());
				books.setStatus("No");
				issue.setMember(member);
				issue.setBooks(books);
				
			}
			else {
				//msg = "failure";
				error_msg3 = "book not present error";
				request.setAttribute("msg3", error_msg3);
				flag =0;
			}
			//dao.Insert(books);
			if(flag == 1) {
				dao.Insert(issue);
				return mapping.findForward("success");
			}else {
				return mapping.findForward("failure");
			}
			
			//request.setAttribute("error_list", error_msg);
			//return mapping.findForward(msg);
			//return mapping.findForward("success");
		}
}
