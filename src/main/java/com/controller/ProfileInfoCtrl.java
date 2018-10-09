package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PassengerDao;
import com.dao.PassengerDaoImpl;
import com.dto.Passenger;
import com.exception.DatabaseException;
import com.exception.FileException;

@WebServlet("/profileinfo")
public class ProfileInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String passengerEmail = (String) session.getAttribute("passengerEmail");
		PassengerDao passengerDao = new PassengerDaoImpl();

		if (passengerEmail != null && !"".equals(passengerEmail)) {
			try {
				Passenger passenger = passengerDao.getPassengerByEmail(passengerEmail);
				if (passenger != null) {
					request.setAttribute("profile", passenger);
					request.getRequestDispatcher("/profile.jsp").forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/");
				}
			} catch (FileException | DatabaseException e) {
				response.sendRedirect(request.getContextPath() + "/error?exception=" + e.getMessage());
			}
			
		} else {
			response.sendRedirect(request.getContextPath() + "/");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}