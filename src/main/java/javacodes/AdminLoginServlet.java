package javacodes;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/loginAdmin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminLoginDao adLoginDao;
	
	public void init() {
		adLoginDao = new AdminLoginDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		try {
			if(adLoginDao.validateAdmin(loginBean)) {
				//ArrayList<String> m =  new ArrayList<String>();
				//m.add("ab"); m.add(username);
				//System.out.println(m.toString());
				
				Cookie ck=new Cookie("admin", username);
				System.out.println(AdminLoginDao.getLoggedInTime().toString());
				ck.setMaxAge(3600);
				response.addCookie(ck);
				
				//request.setAttribute("EMPS",AdminLoginDao.getLoggedInTime());
				//request.setAttribute("EMPS", m);
				
				response.sendRedirect("AdminHome.html");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect! Try Again!');");
				out.println("location='Admin.jsp';");
				out.println("</script>");
				//response.sendRedirect("Admin.jsp");
			}				
		}
		catch(Exception e)
		{System.out.println(e); }
	}

}
