package dao;

import java.util.List;

import dto.Airplane;
import exception.DatabaseException;
import exception.FileException;

public interface AirplaneDao {
	
	public Airplane getAirplaneById(int airplaneId) throws FileException, DatabaseException;
	
	public List<Airplane> getAirplaceList() throws FileException, DatabaseException;
}
