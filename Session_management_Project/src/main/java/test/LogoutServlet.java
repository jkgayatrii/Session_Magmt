package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","session expored");
			
		}
		else {
			hs.removeAttribute("abean");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("msg","logout succesfull..");
			
			
		}
		req.getRequestDispatcher("msg.jsp").forward(req, res);
		
	}

}
