package dao;

import java.time.LocalDateTime;
import java.util.List;

import dto.Flight;
import exception.DatabaseException;
import exception.FileException;

public interface FlightDao {
	public int addFlight(Flight flight) throws FileException, DatabaseException;
	
	public List<Flight> getFlightsByDate(LocalDateTime departureTime) throws FileException, DatabaseException;
	
	public List<Flight> getFlightsByCity(String departureCity, String arrivalCity) throws FileException, DatabaseException;
	
	public int updateFlight(Flight flight) throws DatabaseException, FileException;
	
	public int deleteFlight(int flightId) throws FileException, DatabaseException;
}
