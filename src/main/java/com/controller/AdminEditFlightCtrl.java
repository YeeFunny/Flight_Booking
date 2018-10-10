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
import com.dto.Flight;
import com.exception.DatabaseException;
import com.exception.FileException;
import com.exception.InputException;

@WebServlet("/admineditflight")
public class AdminEditFlightCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	FlightDao flightDao = new FlightDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int flightId = Integer.parseInt(request.getParameter("flightId"));
			String deptCity = request.getParameter("deptCity");
			String arrCity = request.getParameter("arrCity");
			LocalDate deptDate = LocalDate.parse(request.getParameter("deptDate"));
			LocalTime deptTime = LocalTime.parse(request.getParameter("deptTime"));
			LocalDate arrDate = LocalDate.parse(request.getParameter("arrDate"));
			LocalTime arrTime = LocalTime.parse(request.getParameter("arrTime"));
			
			if (deptCity != null && arrCity != null && deptDate != null && deptTime != null
					&& arrDate != null && arrTime != null && flightId != 0) {
				System.out.println("");
				Flight flight = new Flight(flightId, LocalDateTime.of(deptDate, deptTime), LocalDateTime.of(arrDate, arrTime),
						deptCity, arrCity);
				int row = flightDao.updateFlight(flight);
				if (row <= 0) {
					throw new DatabaseException("Cannot update the flight information.");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin_index");
				}
			} else {
				throw new InputException("Invalid input information.");
			}
		} catch (DatabaseException | InputException | FileException e) {
			response.sendRedirect(request.getContextPath() + "/error?exception=" + e.getMessage());
		}
	}

}
