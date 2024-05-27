package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/viewdetails")
public class EmployeedetailsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String eId=req.getParameter("eid");
		HttpSession hs=req.getSession(false);
		EmployeeBean eb= new EmployeedetailsDAO().login(eId);
		
		if(hs==null) {
			req.setAttribute("msg", "No details...");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("viewdetails.jsp").forward(req, res);
		}
	
		
	}
	
}
