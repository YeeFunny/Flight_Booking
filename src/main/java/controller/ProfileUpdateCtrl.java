package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PassengerDao;
import dao.PassengerDaoImpl;
import dto.Passenger;
import exception.DatabaseException;
import exception.FileException;
import util.EnumUtil;

public class ProfileUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String ssn = request.getParameter("ssn");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		int aptNumber = Integer.parseInt(request.getParameter("aptNumber"));
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String telHome = request.getParameter("telHome");
		String telOffice = request.getParameter("telOffice");

		Passenger passenger = new Passenger(firstName, lastName, email, EnumUtil.stringToGender(gender), ssn, age,
				address, aptNumber, city, state, zip, telHome, telOffice);
		PassengerDao passengerDao = new PassengerDaoImpl();
		try {
			int row = passengerDao.updatePassenger(passenger);
			if (row == 1) {
				HttpSession session= request.getSession(true);
				session.setAttribute("passengerEmail", email);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/error.jsp?exception=Update passenger information fails.");
			}
		} catch (FileException | DatabaseException e) {
			response.sendRedirect(request.getContextPath()+"/error.jsp?exception="+ e.getMessage());
		}
	}

}
