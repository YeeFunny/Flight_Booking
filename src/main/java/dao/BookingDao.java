package dao;

import java.util.List;

import dto.Booking;
import dto.Flight;
import exception.DatabaseException;
import exception.FileException;

public interface BookingDao {

	public List<Booking> BookingHistoryByPassengerId(int passengerId) throws FileException, DatabaseException;
	
	public List<Booking> BookingHistory() throws FileException, DatabaseException;
	
	public int BookingFlight(Flight flight, int noOfSeat);
}
