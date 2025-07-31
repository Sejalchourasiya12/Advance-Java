<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file= "Header.jsp" %>
	<%
		String error = (String) request.getAttribute("error");
		String success = (String) request.getAttribute("success");
	%>
	<div align="center">

		<form action="UserRegistrationCtl" method="post">
			<h1>User Registration</h1>
			<div>
				<%
					if (success != null && success.length() > 0) {
				%>
				<font color="Green"><h3><%=success%></h3></font>
				<%
					}
				%>
				<%
					if (error != null && error.length() > 0) {
				%>
				<font color="Red"><h3><%=error%></h3></font>
				<%
					}
				%>
			</div>


			<table>
				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"></td>
				</tr>

				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"></td>
				</tr>

				<tr>
					<th>Login Id :</th>
					<td><input type="text" name="loginId"></td>
				</tr>


				<tr>
					<th>Password :</th>
					<td><input type="text" name="password"></td>
				</tr>



				<tr>
					<th>DOB :</th>
					<td><input type="Date" name="dob" style="width: 96%"></td>
				</tr>


				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"></td>
				</tr>

				<tr>
					<td><input type="submit" value="signUp"></td>
			</table>


		</form>
	</div>


</body>
</html>