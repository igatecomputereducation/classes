import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie[] x=req.getCookies();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<br><br><center>");
		if(x==null)
		{
			pw.println("<form method='post' action='./hello' autocomplete='off'>");
			pw.println("Name &nbsp; <input type='text' name='cname'><br><br>");
			pw.println("<input type='submit' value='submit'>");
			pw.println("</form>");
		}
		else
		{
			pw.println("<h1>Hello "+(String)x[0].getValue()+"</h1>");
			pw.println("<a href='./delcook'>Sign Out</a>");
		}
		pw.println("</center>");
		pw.println("</body>");
		pw.println("</html>");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cname=req.getParameter("cname");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Cookie c=new Cookie("cname",cname);
		c.setMaxAge(3000);
		c.setPath("/");
		res.addCookie(c);
		pw.println("<html><body><center><h1>Done!!!</center></body></html>");
	}

}
