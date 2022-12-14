package admin.approval;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.util.AdminDAO;


public class ApprovalAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApprovalAccessController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pr = resp.getWriter();
		String id = req.getParameter("id");
		String access = req.getParameter("access");
		
		try {
			AdminDAO adminDAO = new AdminDAO();
			int data = adminDAO.updateAccess(id,access);
			
			if(data > 0) {
				pr.print("success");				
			}
			else {
				throw new SQLException();
			}
		}catch (Exception e) {
			pr.print("denial");
			e.printStackTrace();
		}
	}
	

}
