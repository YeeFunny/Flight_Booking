package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.AdminDaoImpl;
import exception.DatabaseException;
import exception.FileException;

@WebServlet("/admin-login")
public class AdminLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDao adminDao = new AdminDaoImpl();
		try {
			String adminName = adminDao.adminLogin(username, password);
			if (adminName != null && !"".equals(adminName)) {
				HttpSession session= request.getSession(true);
				session.setAttribute("adminName", adminName);
				request.getRequestDispatcher("/admin_flight_query.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()+"/admin.jsp?errorMsg=Invalid username or password");
			}
		} catch (FileException | DatabaseException e) {
			response.sendRedirect(request.getContextPath()+"/error.jsp?exception="+ e.getMessage());
		}

	}

}
