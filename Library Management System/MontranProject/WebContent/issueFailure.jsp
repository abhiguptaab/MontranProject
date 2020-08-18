<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Failure </title>
</head>
<body>
	<h3></h3>
	<hr>
	<%! String msg1; %>
	<%! String msg2; %>
	<%! String msg3; %>
	
	
	<%
		msg1 = request.getAttribute("msg1").toString();
		msg2 = request.getAttribute("msg2").toString();
		msg3 = request.getAttribute("msg3").toString();
	%>
	
	<%= msg1 %>
	<%= msg2 %>
	<%= msg3 %>
	
	<a href ="IssueBooks.jsp" > Ok </a>
	
</body>
</html>