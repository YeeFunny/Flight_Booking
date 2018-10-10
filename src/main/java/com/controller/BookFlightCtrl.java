package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookingDao;
import com.dao.BookingDaoImpl;
import com.dao.FlightSeatDao;
import com.dao.FlightSeatDaoImpl;
import com.dto.Booking;
import com.dto.BookingStatus;
import com.dto.FlightClass;
import com.dto.FlightSeat;
import com.exception.DatabaseException;
import com.exception.FileException;
import com.exception.InputException;

@WebServlet("/booking")
public class BookFlightCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BookingDao bookingDao = new BookingDaoImpl();
	FlightSeatDao flightSeatDao = new FlightSeatDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/");
		}
		String passengerId = String.valueOf(session.getAttribute("passengerId"));
		if (passengerId == null) {
			response.sendRedirect(request.getContextPath() + "/");
		}
		int passId = Integer.parseInt(passengerId);
		String flightId = request.getParameter("flightId");
		String business = request.getParameter("business");
		String firstClass = request.getParameter("firstClass");
		String economy = request.getParameter("economy");
		String baggage = request.getParameter("baggage");
		String busiLeft = request.getParameter("businessLeft");
		String firsLeft = request.getParameter("firstLeft");
		String econoLeft = request.getParameter("economyLeft");
		String oldVer = request.getParameter("oldVersion");

		try {
			if (flightId == null || business == null || firstClass == null || economy == null || oldVer == null 
					|| baggage == null || busiLeft == null || firsLeft == null || econoLeft == null) {
				throw new InputException("Invalid input information during booking.");
			}
			int fliId = 0, businessNo = 0, firstNo = 0, economyNo = 0, baggageNo = 0, businessLeft = 0
						, firstLeft = 0, economyLeft = 0, oldVersion = 0;
			if (!flightId.equals(""))  fliId = Integer.parseInt(flightId);
			if (!business.equals("")) businessNo = Integer.parseInt(business);
			if (!firstClass.equals("")) firstNo = Integer.parseInt(firstClass);
			if (!economy.equals("")) economyNo = Integer.parseInt(economy);
			if (!baggage.equals("")) baggageNo = Integer.parseInt(baggage);
			if (!busiLeft.equals("")) businessLeft = Integer.parseInt(busiLeft);
			if (!firsLeft.equals("")) firstLeft = Integer.parseInt(firsLeft);
			if (!econoLeft.equals("")) economyLeft = Integer.parseInt(econoLeft);
			if (!oldVer.equals("")) oldVersion = Integer.parseInt(oldVer);
			
			if (businessNo == 0 && firstNo == 0 && economyNo == 0) {
				throw new InputException("Invalid input information during booking."); 
			}
			
			for (int i = 0; i < businessNo; i++) {
				Booking booking = new Booking(passId, fliId, Integer.parseInt(1 + "" + businessLeft--)
						, baggageNo, FlightClass.BUSINESSCLASS, BookingStatus.RESERVED);
				int bookingId = bookingDao.BookingFlight(booking);
				if (bookingId == 0) {
					throw new DatabaseException("Cannot insert booking information.");
				}
				FlightSeat seat = new FlightSeat(fliId, businessLeft, firstLeft, economyLeft, oldVersion++);
				int row = flightSeatDao.updateFlightSeat(seat);
				if (row <= 0) {
					throw new DatabaseException("Cannot update flight seat information.");
				}
			}
			
			for (int i = 0; i < firstNo; i++) {
				Booking booking = new Booking(passId, fliId, Integer.parseInt(1 + "" + firstLeft--)
						, baggageNo, FlightClass.FIRSTCLASS, BookingStatus.RESERVED);
				int bookingId = bookingDao.BookingFlight(booking);
				if (bookingId == 0) {
					throw new DatabaseException("Cannot insert booking information.");
				}
				FlightSeat seat = new FlightSeat(fliId, businessLeft, firstLeft, economyLeft, oldVersion++);
				int row = flightSeatDao.updateFlightSeat(seat);
				if (row <= 0) {
					throw new DatabaseException("Cannot update flight seat information.");
				}
			}
			
			for (int i = 0; i < economyNo; i++) {
				Booking booking = new Booking(passId, fliId, Integer.parseInt(1 + "" + economyLeft--)
						, baggageNo, FlightClass.ECONOMYCLASS, BookingStatus.RESERVED);
				int bookingId = bookingDao.BookingFlight(booking);
				if (bookingId == 0) {
					throw new DatabaseException("Cannot insert booking information.");
				}
				FlightSeat seat = new FlightSeat(fliId, businessLeft, firstLeft, economyLeft, oldVersion++);
				int row = flightSeatDao.updateFlightSeat(seat);
				if (row <= 0) {
					throw new DatabaseException("Cannot update flight seat information.");
				}
			}
			
			response.sendRedirect(request.getContextPath()+ "/passenger-history");
			
		} catch (InputException | DatabaseException | FileException e) {
			response.sendRedirect(request.getContextPath() + "/error?exception=" + e.getMessage());
		}
	}

}
