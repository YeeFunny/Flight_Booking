package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

@WebServlet("/addflight")
public class AdminAddFlightCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlightDao flightDao = new FlightDaoImpl();
	FlightSeatDao flightSeatDao = new FlightSeatDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String deptCity = request.getParameter("deptCity");
			String arrCity = request.getParameter("arrCity");
			int	airplaneId = Integer.parseInt(request.getParameter("airplaneId"));
			int	firstCap = Integer.parseInt(request.getParameter("firstCap"));
			int	businessCap = Integer.parseInt(request.getParameter("businessCap"));
			int	economyCap = Integer.parseInt(request.getParameter("economyCap"));
			LocalDate deptDate = LocalDate.parse(request.getParameter("deptDate"));
			LocalTime deptTime = LocalTime.parse(request.getParameter("deptTime"));
			LocalDate arrDate = LocalDate.parse(request.getParameter("arrDate"));
			LocalTime arrTime = LocalTime.parse(request.getParameter("arrTime"));
			
			if (deptCity != null && arrCity != null && airplaneId != 0 && deptDate != null && deptTime != null
					&& arrDate != null && arrTime != null) {
				Flight flight = new Flight(LocalDateTime.of(deptDate, deptTime), LocalDateTime.of(arrDate, arrTime),
						deptCity, arrCity, airplaneId);
				int flightId = flightDao.addFlight(flight);
				if (flightId <= 0) {
					throw new DatabaseException("Fails to insert the seat information.");
				} else {
					FlightSeat flightSeat = new FlightSeat(flightId, businessCap, firstCap, economyCap, 1);
					int row = flightSeatDao.addFlightSeat(flightSeat);
					if (row <= 0) {
						throw new DatabaseException("Fails to insert the seat information.");
					} else {
						response.sendRedirect(request.getContextPath() + "/admin_index");
					}
				}
			} else {
				throw new InputException("Invalid input information during add flight.");
			}
		} catch (DatabaseException | InputException | FileException e) {
			response.sendRedirect(request.getContextPath() + "/admin_error?exception=" + e.getMessage());
		}
	}

}
