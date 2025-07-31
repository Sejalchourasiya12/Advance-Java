<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  UserBean bean= (UserBean) session.getAttribute("user"); %>
<% if(bean!=null){ %>
<h3>Hi <%=bean.getFirstName() %></h3>
	<a href="#"><b>Add User</b></a>
	<b>|</b>
	<a href="#"><b>UserList</b></a>
	<b>|</b>
	<a href="LoginCtl?operation=logout"><b>Logout</b></a>
	<hr>
<%} else{ %>
	<h3>Hi Guest</h3>
	<a href="WelcomeCtl"><b>Welcome</b></a>
	<b>|</b>
	<a href="LoginCtl"><b>Login</b></a>
	<hr>
	<%} %>

</body>
</html>