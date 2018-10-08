package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassengerDao;
import dao.PassengerDaoImpl;
import exception.DatabaseException;
import exception.FileException;

@WebServlet("/passenger-login")
public class PassengerLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PassengerDao passengerDao = new PassengerDaoImpl();
		try {
			String passengerEmail = passengerDao.passengerLogin(email, password);
			if (passengerEmail != null && !"".equals(passengerEmail)) {
				HttpSession session= request.getSession(true);
				session.setAttribute("passenger_email", passengerEmail);
				response.sendRedirect(request.getContextPath()+"/flight_query.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/login.jsp?errorMsg=Invalid username or password");
			}
		} catch (FileException | DatabaseException e) {
			response.sendRedirect(request.getContextPath()+"/error.jsp?exception="+ e.getMessage());
		}
	}

}
