<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="main.css">
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<div class="header">
		<br>
		<h1>Construction Site Management System</h1>
	</div>

	<div align="center">
		<h2>Sign Up!</h2>
		<h3>New Employees can create an account here!</h3>
		
		
		<form name="SignUp" method="post" action="<%=request.getContextPath()%>/SignUp">
			<table>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Age: </td>
					<td><input type="number" name="age" /></td>
				</tr>
				<tr>
					<td>D.o.B: </td>
					<td><input type="date" name="dob" /></td>
				</tr>
				<tr>
					<td>Designation: </td>
					<td><input type="text" name="desg" /></td>
				</tr>
				<tr>
					<td>Phone no.:</td>
					<td><input type="number" name="phn" /></td>
				</tr>
				<tr>
					<td>Email Id: </td>
					<td><input type="email" name="mail" /></td>
				</tr>
				<tr>
					<td>Date of Joining: </td>
					<td><input type="date" name="doj" /></td>
				</tr>
				<tr>
					<td>Username: </td>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="password" name="pass" /></td>
				</tr>				
			</table>
			<br>
			<input type="submit" value="Sign Up" />
		</form>
		
	</div>
	<p><a href="home.html">Click here </a>to return to home page.</p>


</body>
</html>