package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","invalid details..<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
			String eid=req.getParameter("eid");
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			Iterator<EmployeeBean>it=al.iterator();
			while(it.hasNext()) {
				EmployeeBean eb=(EmployeeBean)it.next();
				if(eid.equals(eb.geteId())) {
					req.setAttribute("ebean", eb);
					break;
				}
			}
			
			req.getRequestDispatcher("Edit.jsp").forward(req, res);
		}
	}
	
}
