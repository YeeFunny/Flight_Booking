package dao;

import dto.Passenger;
import exception.DatabaseException;
import exception.FileException;

public interface PassengerDao {
	
	public String passengerLogin(String email, String password) throws FileException, DatabaseException;

	public String passengerRegister(Passenger passenger) throws DatabaseException, FileException;
	
	public Passenger getPassengerByEmail(String email) throws FileException, DatabaseException;
	
	public int updatePassenger(Passenger passenger) throws FileException, DatabaseException;
}
