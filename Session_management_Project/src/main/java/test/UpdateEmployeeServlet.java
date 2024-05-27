package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Invalid...<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
			
		}
		else {
			String eId=req.getParameter("eid");
			int bS=Integer.parseInt(req.getParameter("bSal"));
			float h=Float.parseFloat(req.getParameter("hra"));
			float d=Float.parseFloat(req.getParameter("da"));
			float hra=(Float)(bS/h)*100;
			float da=(Float)(bS/d)*100;
			float TotSal=bS+hra+da;
			ArrayList<EmployeeBean>al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");

			Iterator<EmployeeBean>it=al.iterator();
			while(it.hasNext()) {
				EmployeeBean eb=(EmployeeBean)it.next();
				if(eId.equals(eb.geteId())) {
					eb.setbSal(bS);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTotsal(TotSal);
					int k=new UpdateEmployeDAO().update(eb);
					if(k>0) {
						req.setAttribute("msg", "EmployeeUpdated...<br>");
					}
					break;
					
				}
			}
			req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
			
		}
		
	}

}
