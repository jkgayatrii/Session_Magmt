package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session expired..<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
			
		}else {
			EmployeeBean eb=new EmployeeBean();
			eb.seteId(req.getParameter("eid"));
			eb.seteName(req.getParameter("ename"));
			eb.seteDesg(req.getParameter("edesg"));
			int bSal=Integer.parseInt(req.getParameter("bsal"));
			float h=Float.parseFloat(req.getParameter("hra"));
			float d=Float.parseFloat(req.getParameter("da"));
			float hra=(float)(h*bSal)/100;
			float da=(float)(d*bSal)/100;
			float totSal=bSal+hra+da;
			eb.setbSal(bSal);
			eb.setHra(hra);
			eb.setDa(da);
			eb.setTotsal(totSal);
			int k=new AddEmployeeDAO().insert(eb);
			if(k>0) {
				req.setAttribute("msg","Employee added succesfully..<br>");
				req.getRequestDispatcher("AddEmployee.jsp").forward(req,res);
			}
			
		}
	}

}
