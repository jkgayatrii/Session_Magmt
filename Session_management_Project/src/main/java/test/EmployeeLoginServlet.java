package test;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/elogin")
public class EmployeeLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession();
		String eId=req.getParameter("eid");
		ArrayList<EmployeeBean> al=new ViewAllEmployeeDAO().retrive();
		hs.setAttribute("alist", al);
		Iterator<EmployeeBean>it=al.iterator();
		while(it.hasNext()) {
			EmployeeBean eb=(EmployeeBean)it.next();
			if(eId.equals(eb.geteId())) {
				req.setAttribute("msg", "Welcome...");
				hs.setAttribute("ebb", eb);
				
			}else {
				req.setAttribute("msg", "Employee details not avilable...<br>");
			}
			
		}
		req.getRequestDispatcher("EmployeeLogin.jsp").forward(req, res);
	}

}
