package com.montran.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.montran.pojo.Member_Master;
import com.montran.pojo.Book_Master;
import com.montran.pojo.Issue;
import com.montran.util.SessionFactoryUtil;

public class LibraryDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory= SessionFactoryUtil.getFactory();
	
	public List<Issue> getIssuedBooks(){
		session = factory.openSession();
		Query query = session.createQuery("from book_issue_master");
		List<Issue> IssueList = query.list();
		System.out.println( IssueList);
		session.close();
		return IssueList;
	}
	
	public List<Book_Master> getAllBooks(){
		session = factory.openSession();
		Query query = session.createQuery("from book_master");
		List<Book_Master> bookList = query.list();
		System.out.println( bookList);
		session.close();
		return bookList;
	}
	
	public List<Member_Master> getAllMembers(){
		session = factory.openSession();
		Query query = session.createQuery("from member_master");
		List<Member_Master> memberList = query.list();
		System.out.println( memberList);
		session.close();
		return memberList;
	}
	
	public int getIssueSerialNo() {
		session = factory.openSession();
		String hql = "select max(book_issue) from book_issue_master";
		Query query = session.createQuery(hql);
		int serialnolist = query.getMaxResults();
		System.out.println(serialnolist);
		session.close();
		return serialnolist;
	}
	
	public void Update(Issue issue) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.update(issue);
		transaction.commit();
		session.close();
	}
	
	public void Delete(Issue issue) {                   		//delete from book_issue_master
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.delete(issue);
		transaction.commit();
		session.close();
	}
	
	public void Insert(Issue issue) {							//Insert In Book_issue_master Table 
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(issue);
		transaction.commit();
		session.close();
	}
	
	public void Insert(Book_Master book) {						//Insert in BOOK_MASTER table
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}
	
	public void Insert(Member_Master member) {					//Insert in MEMBER_MASTER table
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(member);
		transaction.commit();
		session.close();
	}
	
	public boolean checkBookStatus(List<Book_Master> bookList, String bookCode) {      //Check whether book is present or not
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getBookId().equals(bookCode) ) {
				if(bookList.get(i).getStatus().equals("Yes")||bookList.get(i).getStatus().equals("yes")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkType(List<Member_Master> memberList, String memberCode) {             //Check type of member(Student or faculty)
		for(int i=0; i<memberList.size(); i++) {
			if(memberList.get(i).getMemberId().equals(memberCode) ) {
				if(memberList.get(i).getMemberType().equals("student")) {
					return true;
				}
			}
		}
		return false;
	}
	
}
	