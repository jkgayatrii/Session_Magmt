package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewAllEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session EXpired...");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		
			
		}
		else {
			ArrayList<EmployeeBean> al=new ViewAllEmployeeDAO().retrive();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllEmployee.jsp").forward(req, res);
		}
	}
	

}
