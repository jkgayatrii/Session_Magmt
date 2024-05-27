package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteEmpServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		String eId=req.getParameter("eid");
		int k=new DeleteEmployeDetailsDAO().delete(eId);
		if(k>0) {
			req.setAttribute("msg", "employeedetailsDeleted...");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
	}

}
