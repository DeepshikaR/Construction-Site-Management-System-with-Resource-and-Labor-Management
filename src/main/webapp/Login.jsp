<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="main.css">
<meta charset="ISO-8859-1">
<title>Employee Log In</title>
</head>
<body>
	<div class="header">
		<br>
		<h1>Construction Site Management System</h1>
	</div>

	<div align="center">
		<h2>Employee Login Form</h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Login" />
		</form>
	</div>
	<br>
	<p><a href="home.html">Click here </a>to return to home page.</p>
</body>
</html>