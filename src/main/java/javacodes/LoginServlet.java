package javacodes;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		// System.out.println(username+" "+password);
		try {
			int n = loginDao.validate(loginBean);
			PrintWriter out = response.getWriter();
			if (n == 0) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect! Try Again!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
				//response.sendRedirect("Login.jsp");
			} else if (n == 1) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Logged in successfully!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
				//response.sendRedirect("loginsuccess.jsp");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User already logged in! Return to home page!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
				//response.sendRedirect("Login.jsp");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}