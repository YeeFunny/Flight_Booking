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
import dto.Passenger;
import exception.DatabaseException;
import exception.FileException;

@WebServlet("/profileinfo")
public class ProfileInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String passengerEmail = (String) session.getAttribute("passenger_email");
		PassengerDao passengerDao = new PassengerDaoImpl();

		if (passengerEmail != null && !"".equals(passengerEmail)) {
			try {
				Passenger passenger = passengerDao.getPassengerByEmail(passengerEmail);
				if (passenger != null) {
					request.setAttribute("profile", passenger);
					request.getRequestDispatcher("/profile.jsp").forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}
			} catch (FileException | DatabaseException e) {
				response.sendRedirect(request.getContextPath() + "/error.jsp?exception=" + e.getMessage());
			}
			
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
