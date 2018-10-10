package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlightDao;
import com.dao.FlightDaoImpl;
import com.dao.FlightSeatDao;
import com.dao.FlightSeatDaoImpl;
import com.dto.Flight;
import com.dto.FlightSeat;
import com.exception.DatabaseException;
import com.exception.FileException;
import com.exception.InputException;

@WebServlet("/flightinfo")
public class FlightInfoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightSeatDao flightSeatDao = new FlightSeatDaoImpl();
	FlightDao flightDao = new FlightDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if (request.getParameter("flightId") == null) {
				throw new InputException("Invalid input of flight information.");
			}
			int flightId = Integer.parseInt(request.getParameter("flightId"));
			FlightSeat flightSeat = flightSeatDao.getFlightSeatById(flightId);
			if (flightSeat == null) {
				throw new DatabaseException("Cannot get flight seat information.");
			}
			Flight flight = flightDao.getFlightById(flightId);
			if (flight == null) {
				throw new DatabaseException("Cannot get flight information.");
			}
			request.setAttribute("flight", flight);
			request.setAttribute("seat", flightSeat);
			request.getRequestDispatcher("/booking.jsp").forward(request, response);
		} catch (InputException | DatabaseException | FileException e) {
			response.sendRedirect(request.getContextPath() + "/error?exception=" + e.getMessage());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
