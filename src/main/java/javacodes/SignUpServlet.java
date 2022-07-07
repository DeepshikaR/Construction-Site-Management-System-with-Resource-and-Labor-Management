package javacodes;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignUpDao sud;
	
	public void init()
	{	sud = new SignUpDao(); }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name, dob, doj, phn, email, desg, uname, pass, age;
		LoginBean loginBean = new LoginBean();
		UserBean uBean = new UserBean();

		loginBean.setUsername(request.getParameter("uname"));
		loginBean.setPassword(request.getParameter("pass"));
		
		uBean.setName(request.getParameter("name"));
		uBean.setAge(request.getParameter("age"));
		uBean.setDob(request.getParameter("dob"));
		uBean.setDesg(request.getParameter("desg"));
		uBean.setPhn(request.getParameter("phn"));
		uBean.setEmail(request.getParameter("mail"));
		uBean.setDoj(request.getParameter("doj"));
		
		
		try {
			if (sud.addUser(loginBean, uBean)) {
				response.sendRedirect("SignUpSuccess.jsp");
			} else {
				response.sendRedirect("SignUp.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
