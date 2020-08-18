<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IssUeBooks</title>
</head>
<body>
	<h3>Issue A Book </h3>
	<hr>
	<%! int serialno; %>
	
	
	<%
		//list = request.getAttribute("error_list");
	    serialno = Integer.parseInt(request.getAttribute("serialnum").toString());
	%>
	
	<html:form action="issueBooksAction">
		<table>
			<tr>
				<td>Issue Serial Number</td>
				<td><%=serialno +1%></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Member Name</td>
				<td><html:text property="memberName" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Book Code</td>
				<td><html:text property="bookCode" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><html:text property="bookTitle"  size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><html:text property="bookAuthor"  size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Date of Issue</td>
				<td><html:text property="issueDate"  size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Date of return </td>
				<td><html:text property="returnDate"  size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Submit</html:submit></td>
			</tr>
			<tr>
				<a href="showIssuedBookList.do">Home Page</a>
			</tr>
		</table>
	</html:form>
	
	
	
	<div style="color: red">
		<html:errors />
	</div>
</body>
</html>