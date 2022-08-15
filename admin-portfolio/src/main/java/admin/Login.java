package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean logined = false;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("adminId");
		String password = request.getParameter("adminPassword");
		PrintWriter pr = response.getWriter();
		
		try {
			AdminDAO rd = new AdminDAO();
			logined = rd.selectIdAndPW(id,password);
			
			if(logined == true) {
				HttpSession session = request.getSession();
				if(session.isNew() || session.getAttribute("id") == null) {
					session.setAttribute("id", id);
					request.setAttribute("id", id);
					if(session.isNew()) {
						pr.print("<script>alert('세션생성 및 로그인 되셨습니다.') location.href='./admin_main.jsp';</script>");
						int log = rd.loginHistory(id);	
		
					}
					else {
						pr.print("<script>alert('로그인을 완료했습니다.'); location.href='./admin_main.jsp';</script>");
					}
				}
				else {
					pr.print("<script>alert('이미 로그인하셨습니다.'); location.href='./admin_main.jsp';</script>");
				}
			}
			else {
				throw new Exception("error");
			}
		}catch(Exception e) {
			pr.print("<script>alert('아이디 혹은 패스워드를 다시 확인해주세요'); history.go(-1);</script>");
		}
	}
}