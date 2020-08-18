<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Issued Books</title>
</head>
<body>
	<h3>List Of Issued Books</h3>
	<hr>
	<table width=100%>
		<tr>
			<th>Issue_serial_no</th>
			<th>member Id</th>
			<th>Member Name</th>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Book Author</th>
			<th>Issue Date</th>
			<th>Return Date</th>
		</tr>
		<logic:iterate name="issuebooks" id="issuedbook">
			<tr>
				<td><bean:write name="issuedbook" property="issueSerialNumber" /></td>
				<td><bean:write name="issuedbook" property="member.memberId" /></td>
				<td><bean:write name="issuedbook" property="member.name" /></td>
				<td><bean:write name="issuedbook" property="books.bookId" /></td>
				<td><bean:write name="issuedbook" property="books.bookName" /></td>
				<td><bean:write name="issuedbook" property="books.bookPrice" /></td>
				<td><bean:write name="issuedbook" property="issueDate" /></td>
				<td><bean:write name="issuedbook" property="returnDate" /></td>
			</tr>
		</logic:iterate>
		<tr>
		<a href ="getSerialNumberAction.do">Issue Book</a>
		</tr>
		<tr></tr>
		<tr>
		<a href ="updateBook.jsp">Update Book</a>
		</tr>
		<tr></tr>
		<tr>
		<a href="deleteBook.jsp">Delete Book</a>
		</tr>
	</table>
</body>
</html>