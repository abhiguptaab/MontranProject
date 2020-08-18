<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IssUeBooks</title>
</head>
<body>
	<h3>Update Issued Book </h3>
	<hr>
	<html:form action="updateBookAction">
		<table>
			<tr>
				<td>SerialNo</td>
				<td><html:text property="serialno" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Enter Member Id</td>
				<td><html:text property="memberCode" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Enter Book Id</td>
				<td><html:text property="bookCode" size="20" maxlength="20" /></td>
			</tr>
			<tr>
				<td></td>
				<td><html:submit>Submit</html:submit></td>
			</tr>
		</table>
	</html:form>
</body>
</html>