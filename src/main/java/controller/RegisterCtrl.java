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
import dto.Gender;
import dto.Passenger;
import exception.DatabaseException;
import exception.FileException;
import util.EnumUtil;

@WebServlet("/register")
public class RegisterCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("pass_confirmation");
		Gender gender = EnumUtil.stringToGender(request.getParameter("gender"));
		
		PassengerDao passengerDao = new PassengerDaoImpl();
		try {
			Passenger passenger = passengerDao.getPassengerByEmail(email);
			if (passenger == null) {
				passenger = new Passenger(password, firstName, lastName, email, gender);
				String passengerEmail = passengerDao.passengerRegister(passenger);
				HttpSession session= request.getSession(true);
				session.setAttribute("passengerEmail", passengerEmail);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} else {
				response.sendRedirect(request.getContextPath()+"/register.jsp?errorMsg=Email has been used.");
			}
		} catch (FileException | DatabaseException e) {
			response.sendRedirect(request.getContextPath()+"/error.jsp?exception="+ e.getMessage());
		}
	}

}
