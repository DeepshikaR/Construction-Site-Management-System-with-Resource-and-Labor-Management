<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javacodes.AdminLoginDao"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="main.css">
<meta charset="ISO-8859-1">
<title>Logged In Employees</title>
</head>
<body>
	<div class="header">
		<br>
		<h1>Construction Site Management System</h1>
	</div>

	<div class="desp">
	<h3>Workers</h3>
	

		<%
		Cookie[] cks = request.getCookies();
		if (cks != null) {
			for (int i = 0; i < cks.length; i++) {
				String name = cks[i].getName();
				String value = cks[i].getValue();
				if (name.equals("admin")) {
					RequestDispatcher rd = request.getRequestDispatcher("Users.jsp");
					if(!AdminLoginDao.getLoggedInTimeAlpha().isEmpty()){
						out.println("<h3>Alphabetical Order</h3>");
						for(String a : AdminLoginDao.getLoggedInTimeAlpha()){						
								out.println("<p>"+a+"</p>");	
						}
						out.println("<h3>In Order of Timestamp</h3>");
						for(String a : AdminLoginDao.getLoggedInTime()){						
							out.println("<p>"+a+"</p>");
						}
					}
					else
						out.println("<p>No logged in workers</p>");
						/*rd.include(request, response);
					*/		
				break;
				}
				if (i == (cks.length - 1)) // if all cookie are not valid redirect to error page
				{
			response.sendRedirect("sessionExpired.html");
			return; // to stop further execution
				}
				i++;
			}
		} else {
			response.sendRedirect("sessionExpired.html");
			return; // to stop further execution
		}
		%> 
	
	</div>
	<br>

	<p><a href="AdminHome.html">Click here </a>to return to admin home page.</p>

</body>
</html>