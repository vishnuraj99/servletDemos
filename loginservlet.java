package cookieLoginLogout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginservlet() {
        super();
            }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
		String username=request.getParameter("usrnme");
		String password=request.getParameter("password");
		if(password=="12345") {
			out.print("welcome"+" "+username);
            request.getRequestDispatcher("link.html").include(request, response);  
            Cookie cookie=new Cookie("mycookie",username);
            response.addCookie(cookie);
            

		}
		else {
			out.print("please login with correct credentials");
            request.getRequestDispatcher("loginCookie.html").include(request, response);  
		}
		out.close();
		
	}

}
